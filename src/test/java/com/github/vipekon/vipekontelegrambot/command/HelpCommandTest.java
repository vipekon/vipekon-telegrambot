package com.github.vipekon.vipekontelegrambot.command;

import com.github.vipekon.vipekontelegrambot.javarushclient.command.Command;
import com.github.vipekon.vipekontelegrambot.javarushclient.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.vipekon.vipekontelegrambot.javarushclient.command.CommandName.HELP;
import static com.github.vipekon.vipekontelegrambot.javarushclient.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for Help-command")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandName() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
