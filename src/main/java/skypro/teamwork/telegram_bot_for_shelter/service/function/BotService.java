package skypro.teamwork.telegram_bot_for_shelter.service.function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import skypro.teamwork.telegram_bot_for_shelter.service.function.button.ButtonCatService;
import skypro.teamwork.telegram_bot_for_shelter.service.function.button.ButtonDogService;
import skypro.teamwork.telegram_bot_for_shelter.service.function.button.ButtonService;

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
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandCat,
                ButtonCatService.callbackQueryAfterCommandCat
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.firstLineCat, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "ABOUT_SHELTER_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonAboutShelterCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandAboutShelterCat,
                ButtonCatService.callbackQueryAfterCommandAboutShelterCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.aboutShelterCat, inlineKeyboardDog);
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
     * Данный метод реагирует на нажатие кнопки с индификатором "HOW_TAKE_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonHowTakeCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.howToTakeCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "DATING_RULES_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonDatingRulesCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.datingRulesCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonListOfDocumentsForAdoptingCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.listOfDocumentsForAdoptingCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_TRANSPORTATION_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForTransportationCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForTransportationCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForLittleCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForLittleCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForAdultCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForAdultCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForDisabledCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForDisabledCat, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "LIST_OF_REASONS_FOR_ADOPTING_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonListOfReasonForAdoptingCat(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonCatService.textButtonsAfterCommandGroupHowTakeCat,
                ButtonCatService.callbackQueryAfterCommandGroupHowTakeCat
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.listOfReasonForAdoptingCat, inlineKeyboardDog);
    }


    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CHOOSE_A_SHELTER_DOG"
     * вызывает новый набор кнопок для меню приюта собак
     */
    public void responseOnPressButtonDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandDog,
                ButtonDogService.callbackQueryAfterCommandDog
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.firstLineDog, inlineKeyboardDog);

    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "ABOUT_SHELTER_CAT"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonAboutShelterDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandAboutShelterDog,
                ButtonDogService.callbackQueryAfterCommandAboutShelterDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.aboutShelterDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "HISTORY_OF_SHELTER_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonHistoryOfShelterDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupAboutShelterDog,
                ButtonDogService.callbackQueryAfterCommandGroupAboutShelterDog
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.historyOfShelterDog, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "SCHEDULE_AND_ADDRESS_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonScheduleAndAddressDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupAboutShelterDog,
                ButtonDogService.callbackQueryAfterCommandGroupAboutShelterDog
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.scheduleAndAddressDog, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CONTACT_SECURITY_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonContactSecurityDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupAboutShelterDog,
                ButtonDogService.callbackQueryAfterCommandGroupAboutShelterDog
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.contactSecurityDog, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATION_LEAFY_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationLeafyDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardCat = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupAboutShelterDog,
                ButtonDogService.callbackQueryAfterCommandGroupAboutShelterDog
        );

        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationLeafyDog, inlineKeyboardCat);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "HOW_TAKE_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonHowTakeDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.howToTakeDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "DATING_RULES_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonDatingRulesDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.datingRulesDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "LIST_OF_DOCUMENTS_FOR_ADOPTING_A_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonListOfDocumentsForAdoptingDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.listOfDocumentsForAdoptingDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_TRANSPORTATION_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForTransportationDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForTransportationDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForLittleDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForLittleDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForAdultDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForAdultDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonRecommendationsForHomeDesignForDisabledDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.recommendationsForHomeDesignForDisabledDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "LIST_OF_REASONS_FOR_ADOPTING_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonListOfReasonForAdoptingDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.listOfReasonForAdoptingDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "LIST_OF_VERIFIED_CYNOLOGISTS_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonListOfVerifiedCynologistDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.listOfVerifiedCynologistDog, inlineKeyboardDog);
    }

    /**
     * Данный метод реагирует на нажатие кнопки с индификатором "CYNOLOGISTS_ADVICE_DOG"
     * вызывает новый набор кнопок для меню приюта кошек
     */
    public void responseOnPressButtonCynologistAdviceDog(long chatId, long messageId) {
        InlineKeyboardMarkup inlineKeyboardDog = buttonService.prepareKeyboard(
                ButtonDogService.textButtonsAfterCommandGroupHowTakeDog,
                ButtonDogService.callbackQueryAfterCommandGroupHowTakeDog
        );
        buttonService.responseOnPressButton(chatId, messageId, textVaultService.cynologistAdviceDog, inlineKeyboardDog);
    }
}