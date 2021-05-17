package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * No {@link Command}
 */
public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private static final String NO_MESSAGE = "Я підтримую команди, що починаються зі слеша(/).\n"
            + "Щоб проглянути список команд введіть /help";

    public NoCommand(
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
                NO_MESSAGE
        );
    }
}
