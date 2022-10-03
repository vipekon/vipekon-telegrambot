package com.github.vipekon.vipekontelegrambot.service;

import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.vipekon.vipekontelegrambot.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
