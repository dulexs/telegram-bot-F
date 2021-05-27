package com.github.dulex.telegrambot;

import com.github.dulex.telegrambot.bot.SATelegramBot;
import com.github.dulex.telegrambot.command.Command;
import com.github.dulex.telegrambot.service.SendBotMessageService;
import com.github.dulex.telegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Abstract class for testing {@link Command}'s
 */
abstract class AbstractCommandTest {

    protected SATelegramBot saTelegramBot = Mockito.mock(SATelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(saTelegramBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();

        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(saTelegramBot).execute(sendMessage);
    }
}
