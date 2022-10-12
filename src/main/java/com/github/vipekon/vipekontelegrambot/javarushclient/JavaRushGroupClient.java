package com.github.vipekon.vipekontelegrambot.javarushclient;

import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupsCountRequestArgs;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupInfo;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupRequestArgs;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Client for JavaRush Open API corresponds to Groups
 */

public interface JavaRushGroupClient {

    /**
     * Get all the {@link GroupInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @param requestArgs provided {@link GroupRequestArgs}.
     * @return the collection of the {@link GroupInfo} objects.
     */
    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);

    /**
     * Get all the {@link GroupDiscussionInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @param requestArgs provided {@link GroupRequestArgs}
     * @return the collection of the {@link GroupDiscussionInfo} objects.
     */
    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);

    /**
     * Get count of groups filtered by provided {@link GroupRequestArgs}.
     *
     * @param countRequestArgs provided {@link GroupsCountRequestArgs}.
     * @return the count of the groups.
     */
    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);

    /**
     * Get {@link GroupDiscussionInfo} by provided ID.
     *
     * @param id provided ID.
     * @return {@link GroupDiscussionInfo} object.
     */
    GroupDiscussionInfo getGroupById(Integer id);
}