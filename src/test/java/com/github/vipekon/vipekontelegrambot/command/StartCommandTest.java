package com.github.vipekon.vipekontelegrambot.command;

import com.github.vipekon.vipekontelegrambot.javarushclient.command.Command;
import com.github.vipekon.vipekontelegrambot.javarushclient.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.vipekon.vipekontelegrambot.javarushclient.command.CommandName.START;
import static com.github.vipekon.vipekontelegrambot.javarushclient.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName(){
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}
