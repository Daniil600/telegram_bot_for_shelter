package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Service
public class BotService {





    private final ButtonService buttonService;
    private final TextVaultService textVaultService;

    public BotService(@Lazy ButtonService buttonService, TextVaultService textVaultService) {
        this.buttonService = buttonService;
        this.textVaultService = textVaultService;
    }

    /**
     * Данный метод реагирует на case /start и направляет в метод sendMessage запрос на его срабатывание
     */
    public void startCommandReceived(long chatId, String name) {
        String msgText = ("Добрый день " + name +
                "\nВыберите интересующий Вас приют");
        InlineKeyboardMarkup inlineKeyboard = buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandStart,
                ButtonService.callbackQueryAfterCommandStart);
        buttonService.responseStartButton(chatId, msgText, inlineKeyboard);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "START_BUTTON_FOR_EDIT_MESSAGE"
     * вызывает новый набор кнопок для выбора приюта
     */
    public void startCommandReceivedForEditMessage(long chatId, long messageId, String name) {
        String msgText = ("Добрый день " + name +
                "\nВыберите интересующий Вас приют");
        InlineKeyboardMarkup inlineKeyboard = buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandStart,
                ButtonService.callbackQueryAfterCommandStart);
        buttonService.responseOnPressButton(chatId, messageId, msgText, inlineKeyboard);
    }


    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CHOOSE_A_SHELTER_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonCat(long chatId, long messageId) {
        String msgTextCat = ("Меню приюта кошек ");
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandCat,
                ButtonCatService.callbackQueryAfterCommandCat
        );

        buttonService.responseOnPressButton(chatId, messageId, msgTextCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "ABOUT_SHELTER_CAT"
     * вызывает новый набор кнопок для меню приюта собак
     */
    public void responseOnPressButtonInfo(long chatId, long messageId) {
        String msgTextDog = ("Информация о приюте кошек ");
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandAboutShelterCat
        );
        buttonService.responseOnPressButton(chatId, messageId, msgTextDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "HOW_TAKE_CAT"
     * вызывает новый набор кнопок для меню приюта собак
     */
    public void responseOnPressButtonHowTakeCat(long chatId, long messageId) {
        String msgTextDog = ("Информация о приюте кошек ");
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, msgTextDog, inlineKeyboardDog);
    }


    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "HISTORY_OF_SHELTER_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonHistoryOfShelterCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandGroupAboutShelterCat
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.historyOfShelterCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "SCHEDULE_AND_ADDRESS_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonScheduleAndAddressCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandGroupAboutShelterCat
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.scheduleAndAddressCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CONTACT_SECURITY_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonContactSecurityCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandGroupAboutShelterCat
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.contactSecurityCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATION_LEAFY_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationLeafyCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandGroupAboutShelterCat
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationLeafyCat, inlineKeyboardCat);
    }


    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CHOOSE_A_SHELTER_DOG"
     * вызывает новый набор кнопок для меню приюта собак
     */
    public void responseOnPressButtonDog(long chatId, long messageId) {
        String msgTextDog = ("Меню приюта собак ");
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandDog,
                ButtonDogService.callbackQueryAfterCommandDog
        );

        buttonService.responseOnPressButton(chatId, messageId, msgTextDog, inlineKeyboardDog);

    }


}
