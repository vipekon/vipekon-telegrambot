package com.github.vipekon.vipekontelegrambot.command;

import com.github.vipekon.vipekontelegrambot.javarushclient.JavaRushGroupClient;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupRequestArgs;
import com.github.vipekon.vipekontelegrambot.repository.entity.GroupSub;
import com.github.vipekon.vipekontelegrambot.service.GroupSubService;
import com.github.vipekon.vipekontelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.stream.Collectors;

import static com.github.vipekon.vipekontelegrambot.command.CommandName.ADD_GROUP_SUB;
import static com.github.vipekon.vipekontelegrambot.command.CommandUtils.getChatId;
import static com.github.vipekon.vipekontelegrambot.command.CommandUtils.getMessage;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * Add Group subscription {@link Command}.
 */
public class   AddGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final JavaRushGroupClient javaRushGroupClient;
    private final GroupSubService groupSubService;

    public AddGroupSubCommand(SendBotMessageService sendBotMessageService, JavaRushGroupClient javaRushGroupClient,
                              GroupSubService groupSubService) {
        this.sendBotMessageService = sendBotMessageService;
        this.javaRushGroupClient = javaRushGroupClient;
        this.groupSubService = groupSubService;
    }

    @Override
    public void execute(Update update) {
        if (getMessage(update).equalsIgnoreCase(ADD_GROUP_SUB.getCommandName())) {
            sendGroupIdList(getChatId(update));
            return;
        }
        String groupId = getMessage(update).split(SPACE)[1];
        Long chatId = getChatId(update);
        if (isNumeric(groupId)) {
            GroupDiscussionInfo groupById = javaRushGroupClient.getGroupById(Integer.parseInt(groupId));
            if (isNull(groupById.getId())) {
                sendGroupNotFound(chatId, groupId);
            }
            GroupSub savedGroupSub = groupSubService.save(chatId, groupById);
            sendBotMessageService.sendMessage(chatId, "???????????????? ???? ???????????? " + savedGroupSub.getTitle());
        } else {
            sendGroupNotFound(chatId, groupId);
        }
    }

    private void sendGroupNotFound(Long chatId, String groupId) {
        String groupNotFoundMessage = "?????? ???????????? ?? ID = \"%s\"";
        sendBotMessageService.sendMessage(chatId, String.format(groupNotFoundMessage, groupId));
    }

    private void sendGroupIdList(Long chatId) {
        String groupIds = javaRushGroupClient.getGroupList(GroupRequestArgs.builder().build()).stream()
                .map(group -> String.format("%s - %s \n", group.getTitle(), group.getId()))
                .collect(Collectors.joining());

        String message = "?????????? ?????????????????????? ???? ???????????? - ?????????????? ?????????????? ???????????? ?? ID ????????????. \n" +
                "????????????????: /addGroupSub 16. \n\n" +
                "?? ???????????????????? ???????????? ???????? ?????????? - ?????????????? ?????????? ???????????? :) \n\n" +
                "?????? ???????????? - ID ???????????? \n\n" +
                "%s";

        sendBotMessageService.sendMessage(chatId, String.format(message, groupIds));
    }
}