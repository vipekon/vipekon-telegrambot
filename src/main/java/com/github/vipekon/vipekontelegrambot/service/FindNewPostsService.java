package com.github.vipekon.vipekontelegrambot.service;

/**
 * Service for finding new articles.
 */

public interface FindNewPostsService {

    /**
     * Find new articles and notify subscribers about it.
     */
    void findNewPosts();
}
