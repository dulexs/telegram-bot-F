package com.github.dulex.telegrambot;

import com.github.dulex.telegrambot.bot.SATelegramBot;
import com.github.dulex.telegrambot.service.SendBotMessageService;
import com.github.dulex.telegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private SATelegramBot saTelegramBot;

    @BeforeEach
    public void init() {
        saTelegramBot = Mockito.mock(SATelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(saTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId= "test_chat_id";
        String message = "message";

        SendMessage sendMessage= new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(saTelegramBot).execute(sendMessage);
    }

}
