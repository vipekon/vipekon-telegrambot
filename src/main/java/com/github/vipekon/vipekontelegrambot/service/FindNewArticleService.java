package com.github.vipekon.vipekontelegrambot.service;

/**
 * Service for finding new articles.
 */

public interface FindNewArticleService  {

    /**
     * Find new articles and notify subscribers about it.
     */
    void findNewArticles();
}
