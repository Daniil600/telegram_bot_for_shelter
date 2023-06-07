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
    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
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
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/cat":
                    catCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/dog":
                    dogCommandReceived(chatId, update.getMessage().getChat().getFirstName());

                    break;

                case "/catinfo":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/catadopt":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/catreport":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/doginfo":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/dogadopt":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/dogreport":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;

                case "/volunteer":
                    dummy(chatId, update.getMessage().getChat().getFirstName());
                    break;


                default:
                    sendMessage(chatId, "Поторите попытку, такой комманды нет");
                    break;
            }
        }

    }

    /**
     * Данный метод реагирует на case /start и направляет в метод sendMessage запрос на его срабатывание
     */
    private void startCommandReceived(long chatId, String name) {
        String answer = "Добро пожаловать " + name +
                ", выберите необходимый приют: \n\n " +
                "/cat - перенаправить в приют котиков. \n\n " +
                "/dog - перенаправить в приют песелей.";
        sendMessage(chatId, answer);
    }

    /**
     * Данный метод реагирует на case /cat и направляет в метод sendMessage запрос на его срабатывание
     */
    private void catCommandReceived(long chatId, String name) {
        String answer = "Добро пожаловать в кошачий приют " + name +
                ", что Вас интересует? \n\n " +
                "/catinfo - получить информацию о приюте . \n\n " +
                "/catadopt - получить информацию о том как взять животное из приюта. \n\n " +
                "/catreport - прислать отчет о состоянии опекаемого питомца. \n\n " +
                "/volunteer - связаться с свободным волонтером.";
        sendMessage(chatId, answer);
    }

    /**
     * Данный метод реагирует на case /dog и направляет в метод sendMessage запрос на его срабатывание
     */
    private void dogCommandReceived(long chatId, String name) {
        String answer = "Добро пожаловать в собачий приют " + name +
                ", что Вас интересует? \n\n " +
                "/doginfo - получить информацию о приюте . \n\n " +
                "/dogadopt - получить информацию о том как взять животное из приюта. \n\n " +
                "/dogreport - прислать отчет о состоянии опекаемого питомца. \n\n " +
                "/volunteer - связаться с свободным волонтером.";
        sendMessage(chatId, answer);
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

    /**
     * Далее идут методы заглушки, которые далее будут стираться и переноситься в нормальное место
     */

    private void dummy(long chatId, String name) {
        String answer = "Функция в стадии реализации";
        sendMessage(chatId, answer);
    }
}
