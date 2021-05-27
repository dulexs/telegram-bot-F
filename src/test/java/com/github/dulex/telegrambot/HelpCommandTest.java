package com.github.dulex.telegrambot;

import com.github.dulex.telegrambot.bot.SATelegramBot;
import com.github.dulex.telegrambot.command.Command;

import com.github.dulex.telegrambot.command.HelpCommand;
import com.github.dulex.telegrambot.service.SendBotMessageService;
import com.github.dulex.telegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.dulex.telegrambot.command.CommandName.HELP;
import static com.github.dulex.telegrambot.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}

