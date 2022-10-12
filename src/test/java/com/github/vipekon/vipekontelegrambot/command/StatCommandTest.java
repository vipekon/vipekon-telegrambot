package com.github.vipekon.vipekontelegrambot.command;

import com.github.vipekon.vipekontelegrambot.javarushclient.command.Command;
import com.github.vipekon.vipekontelegrambot.javarushclient.command.StatCommand;

import static com.github.vipekon.vipekontelegrambot.javarushclient.command.CommandName.STAT;
import static com.github.vipekon.vipekontelegrambot.javarushclient.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
