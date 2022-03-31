package ru.liga.prerevolutionarytindertgbotclient;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.liga.prerevolutionarytindertgbotclient.telegrambot.RussianOldTinderBot;

/**
 * Start Bot!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new RussianOldTinderBot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
