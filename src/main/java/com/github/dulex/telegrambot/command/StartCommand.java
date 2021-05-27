package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}
 */
public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привіт. Я твій новий Telegram Bot. Я допоможу тобі бути в курсі останніх " +
            "статей тих авторів, які тебе цікавлять.";


    // No need to add service via Application Context.
    // if we do it, we got loop dependency
    // which breaks workflow
    public StartCommand(
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
                START_MESSAGE
        );
    }
}
