package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.dulex.telegrambot.command.CommandName.*;

/**
 * Help {@link Command}
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Доступні команди</b>✨\n\n"
                    + "<b>Почати \\ работу з ботом</b>\n"
                    + "%s - почати работу зі мною\n"
                    + "%s - зупинти роботу зі мною\n\n"
                    + "%s - отримати допомогу в роботі зі мною\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(
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
                HELP_MESSAGE
        );
    }
}
