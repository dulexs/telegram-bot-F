package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Surprise {@link Command}
 */
public class SurpriseCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String SURPRISE_MESSAGE = "Тебе чекає сюрприз, не поспішай, ти його скоро отримаєш";

    public SurpriseCommand(
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
                SURPRISE_MESSAGE
        );
    }
}
