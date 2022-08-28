package com.github.vipekon.vipekontelegrambot.service;

import com.github.vipekon.vipekontelegrambot.bot.VipekonTelegramBot ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final VipekonTelegramBot vipekonBot;

    @Autowired
    public SendBotMessageServiceImpl (VipekonTelegramBot vipekonBot) {
        this.vipekonBot = vipekonBot;
    }

    @Override
    public void sendMessage (String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            vipekonBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
