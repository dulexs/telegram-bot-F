package com.github.dulex.telegrambot.service;

import com.github.dulex.telegrambot.bot.SATelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of link{@link SendBotMessageService} interface
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final SATelegramBot saTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(
            SATelegramBot saTelegramBot
    ) {
        this.saTelegramBot = saTelegramBot;
    }

    @Override
    public void sendMessage(
            String chatId,
            String message
    ) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            saTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
