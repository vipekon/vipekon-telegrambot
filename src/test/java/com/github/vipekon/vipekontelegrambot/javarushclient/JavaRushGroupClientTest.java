package com.github.vipekon.vipekontelegrambot.javarushclient;

import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupInfo;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupRequestArgs;
import com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupsCountRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static com.github.vipekon.vipekontelegrambot.javarushclient.dto.GroupInfoType.TECH;

@DisplayName("Integration-level testing for JavaRushGroupClientImplTest")
class JavaRushGroupClientTest {

    public static final String JAVARUSH_API_PATH = "https://javarush.ru/api/1.0/rest";
    private final JavaRushGroupClient groupClient = new JavaRushGroupClientImpl("https://javarush.ru/api/1.0/rest");

    @Test
    public void shouldProperlyGetGroupsWithEmptyArgs() {
        //given
        GroupRequestArgs args = GroupRequestArgs.builder().build();

        //when
        List<GroupInfo> groupList = groupClient.getGroupList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetWithOffSetAndLimit() {
        //given
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        //when
        List<GroupInfo> groupList = groupClient.getGroupList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3,groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupsDiscWithEmptyArgs() {
        //given
        GroupRequestArgs args = GroupRequestArgs.builder().build();

        //when
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetGroupDiscWithOffSetAndLimit() {
        //given
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        //when
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupTECHCount() {
        //given
        GroupsCountRequestArgs args = GroupsCountRequestArgs.builder()
                .type(TECH)
                .build();

        //when
        Integer groupCount = groupClient.getGroupCount(args);

        //then
        Assertions.assertEquals(7, groupCount);
    }

    @Test
    public void shouldProperlyGetGroupById() {
        //given
        Integer androidGroupId = 16;

        //when
        GroupDiscussionInfo groupById = groupClient.getGroupById(androidGroupId);

        //then
        Assertions.assertNotNull(groupById);
        Assertions.assertEquals(16, groupById.getId());
        Assertions.assertEquals(TECH, groupById.getType());
        Assertions.assertEquals("android", groupById.getKey());
    }
}
