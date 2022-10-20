package com.github.vipekon.vipekontelegrambot.command;

public enum CommandName {

    START ("/start"),
    STOP ("/stop"),
    HELP ("/help"),
    STAT ("/stat"),
    ADD_GROUP_SUB ("/addgroupsub"),
    LIST_GROUP_SUB("/listGroupSub"),
    DELETE_GROUP_SUB("/deleteGroupSub"),
    ADMIN_HELP("/ahelp"),
    NO ("nocommand");


    private final String commandName;

    CommandName (String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
