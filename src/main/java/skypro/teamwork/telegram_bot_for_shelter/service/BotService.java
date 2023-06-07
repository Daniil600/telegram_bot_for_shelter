package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Service
public class BotService {


    private final ButtonService buttonService;

    public BotService(@Lazy ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    /**
     * Данный метод реагирует на case /start и направляет в метод sendMessage запрос на его срабатывание
     */
    public void startCommandReceived(long chatId, String name) {
        String msgText = ("Привет друг! " + name +
                "\nВыбери приют");
        InlineKeyboardMarkup inlineKeyboard = buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandStart,
                ButtonService.callbackQueryAfterCommandStart);
        buttonService.responseOnPressButton(chatId, msgText, inlineKeyboard);
    }
    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "cat"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonCat(long chatId) {
        String msgTextCat = ("Меню приюта кошек ");
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandCat,
                ButtonService.callbackQueryAfterCommandCat
        );

        buttonService.responseOnPressButton(chatId, msgTextCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "dog"
     * вызывает новый набор кнопок для меню приюта собак
     */
    public void responseOnPressButtonDog(long chatId) {
        String msgTextDog = ("Меню приюта собак ");
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandDog,
                ButtonService.callbackQueryAfterCommandDog
        );

        buttonService.responseOnPressButton(chatId, msgTextDog, inlineKeyboardDog);

    }


}
