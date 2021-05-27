package com.github.dulex.telegrambot;

import com.github.dulex.telegrambot.command.Command;
import com.github.dulex.telegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.dulex.telegrambot.command.CommandName.NO;
import static com.github.dulex.telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
