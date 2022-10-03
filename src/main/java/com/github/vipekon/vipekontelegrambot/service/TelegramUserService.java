package com.github.vipekon.vipekontelegrambot.service;

import com.github.vipekon.vipekontelegrambot.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {
    void save (TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatId);
}
