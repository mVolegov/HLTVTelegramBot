package com.voleg;

import com.voleg.bot.HLTVBot;
import com.voleg.confing.AppConfigurer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Run {

    public static void main(String[] args) throws TelegramApiException {
        HLTVBot bot = AppConfigurer.configure();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
