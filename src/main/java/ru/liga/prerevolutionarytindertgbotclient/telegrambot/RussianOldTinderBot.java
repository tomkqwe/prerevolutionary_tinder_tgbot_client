package ru.liga.prerevolutionarytindertgbotclient.telegrambot;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.prerevolutionarytindertgbotclient.Communication;
import ru.liga.prerevolutionarytindertgbotclient.configuration.MyConfig;
import ru.liga.prerevolutionarytindertgbotclient.entity.User;
import ru.liga.prerevolutionarytindertgbotclient.utils.PropertiesUtil;


public class RussianOldTinderBot extends TelegramLongPollingBot {
    private static final String BOT_USERNAME_KEY = "bot.name";
    private static final String BOT_TOKEN_KEY = "bot.token";
    @Override
    public String getBotUsername() {
        return PropertiesUtil.get(BOT_USERNAME_KEY);
    }

    @Override
    public String getBotToken() {
        return PropertiesUtil.get(BOT_TOKEN_KEY);
    }


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();

            try {

                returnUserById(update, chatId);

            } catch (TelegramApiException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * Берем месседж парсим айдишку
     * @param update
     * @param chatId
     * @throws TelegramApiException
     */
    private void returnUserById(Update update, Long chatId) throws TelegramApiException {
        String s = update.getMessage().getText();
        String[] split = s.split(" ");
        int i = Integer.parseInt(split[1]);
        execute(new SendMessage(chatId.toString(), getUserById(i).toString()));
    }

    private User getUserById(int id) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        return communication.getUser(id);
    }

}
