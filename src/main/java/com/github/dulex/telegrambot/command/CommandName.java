package com.github.dulex.telegrambot.command;

/**
 * Enumeration for {@link Command}'s
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    SURPRISE("/surprise"),
    HELP("/help"),
    NO("/no");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
