package com.github.dulex.telegrambot.bot;

import com.github.dulex.telegrambot.command.CommandContainer;
import com.github.dulex.telegrambot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import com.github.dulex.telegrambot.command.CommandName.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.dulex.telegrambot.command.CommandName.NO;

@Component
public class SATelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    private static final String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    public SATelegramBot() {
        this.commandContainer = new CommandContainer(
                new SendBotMessageServiceImpl(this)
        );
    }

    @Override
    public void onUpdateReceived(
            Update update
    ) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
