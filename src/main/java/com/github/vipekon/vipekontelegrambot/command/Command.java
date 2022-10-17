package com.github.vipekon.vipekontelegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;


public interface Command {

    void execute (Update update);
}
