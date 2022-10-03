package com.github.vipekon.vipekontelegrambot.repository;

import com.github.vipekon.vipekontelegrambot.repository.entity.GroupSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Repository} for {@link GroupSub} entity.
 */

@Repository
public interface GroupSubRepository extends JpaRepository<GroupSub, Integer>{
}
