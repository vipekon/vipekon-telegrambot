package com.github.vipekon.vipekontelegrambot.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tg_user")
@EqualsAndHashCode(exclude = "groupSubs")
public class TelegramUser {

    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<GroupSub> groupSubs;

}
