package ru.liga.prerevolutionarytindertgbotclient.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class RussianOldTinderBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "prerevolutionaryTinder_bot";
    }

    @Override
    public String getBotToken() {
        return "5192300654:AAF_oVYZy-qXsv5dFqzk2IyEt6SosBwpc8I";
    }


    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
