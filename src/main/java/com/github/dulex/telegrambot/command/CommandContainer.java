package com.github.dulex.telegrambot.command;

import com.github.dulex.telegrambot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.dulex.telegrambot.command.CommandName.*;

/**
 * Container of the {@link Command}'s, which are user for handling telegram commands.
 */
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(
            SendBotMessageService sendBotMessageService
    ) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(SURPRISE.getCommandName(), new SurpriseCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(
                sendBotMessageService
        );
    }

    public Command retrieveCommand(String commandID) {
        return commandMap.getOrDefault(
                commandID, unknownCommand
        );
    }
}
