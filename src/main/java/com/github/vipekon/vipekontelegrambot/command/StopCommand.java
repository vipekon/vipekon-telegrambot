package com.github.vipekon.vipekontelegrambot.command;

import com.github.vipekon.vipekontelegrambot.repository.entity.TelegramUser;
import com.github.vipekon.vipekontelegrambot.service.SendBotMessageService;
import com.github.vipekon.vipekontelegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

import static com.github.vipekon.vipekontelegrambot.command.CommandUtils.getChatId;

/**
 * Stop {@link Command}
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand (SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute (Update update) {
        sendBotMessageService.sendMessage(getChatId(update), STOP_MESSAGE);
        telegramUserService.findByChatId(getChatId(update))
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
