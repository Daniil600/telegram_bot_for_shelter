package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import skypro.teamwork.telegram_bot_for_shelter.config.BotConfig;

@Component
/** Данный класс наследуется из TelegramLongPollingBot и переопределяет методы в конструкторе
 * для взаимодействия нашей программы с ботом через класс BotConfig,
 * в котором имеются геттеры созданные библиотекой ломбок */
public class TelegramBot extends TelegramLongPollingBot {

    /**
     * Инициализация класса, в котором хранится имя и токен бота
     */
    private final BotConfig config;
    private final BotService botService;

    public TelegramBot(BotConfig config, BotService botService) {
        this.config = config;
        this.botService = botService;
    }

    /**
     * Переопределение методов под наши задачи из класса TelegramLongPollingBot
     */
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    /**
     * Данный метод отслеживает какое сообщение пришло от пользователя в update и выполняет функционал взависимости
     * от полученного сообщения путем свитч кейс
     */
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();



            switch (messageText) {
                case "/start":
                    botService.startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                default:
                    sendMessage(chatId, "Поторите попытку, такой комманды нет");
                    break;
            }

        } else if (update.hasCallbackQuery()) {
            String callbackQuery = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();

            switch (callbackQuery) {
                case "cat":
                    botService.responseOnPressButtonCat(chatId, messageId);
                    break;
                case "dog":
                    botService.responseOnPressButtonDog(chatId, messageId);
                    break;
                case "ABOUT_SHELTER_CAT":
                    botService.responseOnPressButtonInfo(chatId, messageId);
                    break;
                case "HOW_TAKE_CAT":
                    botService.responseOnPressButtonTakeInfo(chatId, messageId);
                    break;
                default:
                    sendMessage(chatId, "Поторите попытку, такой комманды нет");
                    break;
            }
        }

    }
    /**
     * Данный метод получает входящие данные и несет в себе функционал отправки их пользователю
     */
    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e) {

        }
    }
}
