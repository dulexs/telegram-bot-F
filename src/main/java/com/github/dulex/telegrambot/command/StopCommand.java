package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private static final String STOP_MESSAGE = "Деактивація усіх підписок \uD83D\uDE1F.";

    public StopCommand(
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
                STOP_MESSAGE
        );
    }
}
