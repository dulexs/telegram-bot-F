package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Unknown {@link Command}
 */
public class UnknownCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private static final String UNKNOWN_MESSAGE = "Не розумію Вас \uD83D\uDE1F, напишіть /help щоб взнати що я розумію.";

    public UnknownCommand(
            SendBotMessageService sendBotMessageService
    ) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(
            Update update
    ) {
        sendBotMessageService.sendMessage(
                update.getMessage().getChatId().toString(),
                UNKNOWN_MESSAGE
        );
    }
}
