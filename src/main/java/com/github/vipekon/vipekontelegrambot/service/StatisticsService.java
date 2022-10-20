package com.github.vipekon.vipekontelegrambot.service;

import com.github.vipekon.vipekontelegrambot.javarushclient.dto.StatisticDTO;

/**
 * Service for getting bot statistics.
 */

public interface StatisticsService {
    StatisticDTO countBotStatistic();
}
