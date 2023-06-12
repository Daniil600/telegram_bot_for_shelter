package skypro.teamwork.telegram_bot_for_shelter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

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

    @Service
    public static class ButtonCatService {
        /**
         * ArrayList c кнопками меню после нажатия кнопки "CHOOSE_A_SHELTER_CAT"
         */
        public static final List<String> textButtonsAfterCommandCat = new ArrayList<>(List.of(
                "О приюте кошек",
                "Как взять питомца из приюта",
                "Прислать отчет о питомце",
                "Позвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "CHOOSE_A_SHELTER_CAT"
         */
        public static final List<String> callbackQueryAfterCommandCat = new ArrayList<>(List.of(
                "ABOUT_SHELTER_CAT",
                "HOW_TAKE_CAT",
                "SEND_REPORT_CAT",
                "VOLUNTEER",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));





        /**
         * ArrayList c кнопками меню после нажатия кнопки "ABOUT_SHELTER_CAT"
         */

        public static final List<String> textButtonsAfterCommandAboutShelterCat = new ArrayList<>(List.of(
                "Рассказ о приюте",
                "Расписание и адрес",
                "Контактные данные охраны",
                "Рекомандация по технике безопасности на территории",
                "Принять контактные данные для связи",
                "Вызвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "ABOUT_SHELTER_CAT"
         */
        public static final List<String> callbackQueryAfterCommandAboutShelterCat = new ArrayList<>(List.of(
                "HISTORY_OF_SHELTER_CAT",
                "SCHEDULE_AND_ADDRESS_CAT",
                "CONTACT_SECURITY_CAT",
                "RECOMMENDATION_LEAFY_CAT",
                "TAKE_CONTACT_FOR_FEEDBACK",
                "VOLUNTEER",
                "CHOOSE_A_SHELTER_CAT"
        ));





        /**
         * ArrayList c кнопками меню после нажатия кнопки "HOW_TAKE_CAT"
         */
        public static final List<String> textButtonsAfterCommandHowTakeCat = new ArrayList<>(List.of(
                "Правила знакомства с животным",
                "Список документов для опеки",
                "Рекоммендации по транспортировке",
                "Рекомандации по обустройству дома для юного питомца",
                "Рекомандации по обустройству дома для взрослого питомца",
                "Рекомандации по обустройству дома для питомца с ограниченными возможностями",
                "Список причин отказа в опеке",
                "Принять контактные данные для связи",
                "Вызвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "HOW_TAKE_CAT"
         */
        public static final List<String> callbackQueryAfterCommandHowTakeCat = new ArrayList<>(List.of(
                "DATING_RULES_CAT",
                "LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT",
                "RECOMMENDATIONS_FOR_TRANSPORTATION_CAT",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT",
                "LIST_OF_REASONS_FOR_ADOPTING_CAT",
                "TAKE_CONTACT_FOR_FEEDBACK",
                "VOLUNTEER",
                "CHOOSE_A_SHELTER_CAT"
        ));





        /**
         * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  ABOUT_SHELTER_CAT"
         * список кнопок
         * HISTORY_OF_SHELTER_CAT
         * SCHEDULE_AND_ADDRESS_CAT
         * CONTACT_SECURITY_CAT
         * RECOMMENDATION_LEAFY_CAT"
         */
        public static final List<String> textButtonsAfterCommandGroupAboutShelterCat = new ArrayList<>(List.of(
                "Назад",
                "Вернуться в начало"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  ABOUT_SHELTER_CAT"
         * список кнопок
         * HISTORY_OF_SHELTER_CAT
         * SCHEDULE_AND_ADDRESS_CAT
         * CONTACT_SECURITY_CAT
         * RECOMMENDATION_LEAFY_CAT"
         */
        public static final List<String> callbackQueryAfterCommandGroupAboutShelterCat = new ArrayList<>(List.of(
                "ABOUT_SHELTER_CAT",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));



        /**
         * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  HOW_TAKE_CAT"
         * список кнопок
         * DATING_RULES_CAT
         * LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT
         * RECOMMENDATIONS_FOR_TRANSPORTATION_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT
         * LIST_OF_REASONS_FOR_ADOPTING_CAT
         */
        public static final List<String> textButtonsAfterCommandGroupHowTakeCat = new ArrayList<>(List.of(
                "Назад",
                "Вернуться в начало"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  HOW_TAKE_CAT"
         * список кнопок
         * DATING_RULES_CAT
         * LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT
         * RECOMMENDATIONS_FOR_TRANSPORTATION_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT
         * LIST_OF_REASONS_FOR_ADOPTING_CAT
         */
        public static final List<String> callbackQueryAfterCommandGroupHowTakeCat = new ArrayList<>(List.of(
                "HOW_TAKE_CAT",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));
    }

    @Service
    public static class ButtonDogService {
        /**
         * ArrayList c кнопками меню после нажатия кнопки "CHOOSE_A_SHELTER_DOG"
         */
        public static final List<String> textButtonsAfterCommandDog = new ArrayList<>(List.of(
                "О собачьем приюте",
                "Как взять питомца из приюта",
                "Прислать отчет о питомце",
                "Позвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "CHOOSE_A_SHELTER_DOG"
         */
        public static final List<String> callbackQueryAfterCommandDog = new ArrayList<>(List.of(
                "ABOUT_SHELTER_DOG",
                "HOW_TAKE_DOG",
                "SEND_REPORT_DOG",
                "VOLUNTEER",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));


        /**
         * ArrayList c кнопками меню после нажатия кнопки "ABOUT_SHELTER_DOG"
         */

        public static final List<String> textButtonsAfterCommandAboutShelterDog = new ArrayList<>(List.of(
                "Рассказ о приюте",
                "Расписание и адрес",
                "Контактные данные охраны",
                "Рекомандация по технике безопасности на территории",
                "Принять контактные данные для связи",
                "Вызвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "ABOUT_SHELTER_DOG"
         */
        public static final List<String> callbackQueryAfterCommandAboutShelterDog = new ArrayList<>(List.of(
                "HISTORY_OF_SHELTER_DOG",
                "SCHEDULE_AND_ADDRESS_DOG",
                "CONTACT_SECURITY_DOG",
                "RECOMMENDATION_LEAFY_DOG",
                "TAKE_CONTACT_FOR_FEEDBACK",
                "VOLUNTEER",
                "CHOOSE_A_SHELTER_DOG"
        ));


        /**
         * ArrayList c кнопками меню после нажатия кнопки "HOW_TAKE_DOG"
         */
        public static final List<String> textButtonsAfterCommandHowTakeDog = new ArrayList<>(List.of(
                "Правила знакомства с животным",
                "Список документов для опеки",
                "Рекоммендации по транспортировке",
                "Рекомандации по обустройству дома для юного питомца",
                "Рекомандации по обустройству дома для взрослого питомца",
                "Рекомандации по обустройству дома для питомца с ограниченными возможностями",
                "Список причин отказа в опеке",
                "Список проверенных кинологов",
                "Советы кинологов по первичному общению с питомцем",
                "Принять контактные данные для связи",
                "Вызвать волонтёра",
                "Назад"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопки "HOW_TAKE_DOG"
         */
        public static final List<String> callbackQueryAfterCommandHowTakeDog = new ArrayList<>(List.of(
                "DATING_RULES_DOG",
                "LIST_OF_DOCUMENTS_FOR_ADOPTING_DOG",
                "RECOMMENDATIONS_FOR_TRANSPORTATION_DOG",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_DOG",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_DOG",
                "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_DOG",
                "LIST_OF_REASONS_FOR_ADOPTING_DOG",
                "LIST_OF_VERIFIED_CYNOLOGISTS_DOG",
                "CYNOLOGISTS_ADVICE_DOG",
                "TAKE_CONTACT_FOR_FEEDBACK",
                "VOLUNTEER",
                "CHOOSE_A_SHELTER_DOG"
        ));


        /**
         * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  ABOUT_SHELTER_DOG"
         * список кнопок
         * HISTORY_OF_SHELTER_DOG
         * SCHEDULE_AND_ADDRESS_DOG
         * CONTACT_SECURITY_DOG
         * RECOMMENDATION_LEAFY_DOG"
         */
        public static final List<String> textButtonsAfterCommandGroupAboutShelterDog = new ArrayList<>(List.of(
                "Назад",
                "Вернуться в начало"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  ABOUT_SHELTER_DOG
         * список кнопок
         * HISTORY_OF_SHELTER_DOG
         * SCHEDULE_AND_ADDRESS_DOG
         * CONTACT_SECURITY_DOG
         * RECOMMENDATION_LEAFY_DOG"
         */
        public static final List<String> callbackQueryAfterCommandGroupAboutShelterDog = new ArrayList<>(List.of(
                "ABOUT_SHELTER_DOG",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));


        /**
         * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  HOW_TAKE_DOG
         * список кнопок
         * DATING_RULES_DOG
         * LIST_OF_DOCUMENTS_FOR_ADOPTING_DOG
         * RECOMMENDATIONS_FOR_TRANSPORTATION_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_DOG
         * LIST_OF_REASONS_FOR_ADOPTING_DOG
         * LIST_OF_VERIFIED_CYNOLOGISTS
         * CYNOLOGISTS_ADVICE
         */
        public static final List<String> textButtonsAfterCommandGroupHowTakeDog = new ArrayList<>(List.of(
                "Назад",
                "Вернуться в начало"
        ));

        /**
         * ArrayList c индификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  HOW_TAKE_DOG
         * список кнопок
         * DATING_RULES_DOG
         * LIST_OF_DOCUMENTS_FOR_ADOPTING_DOG
         * RECOMMENDATIONS_FOR_TRANSPORTATION_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_DOG
         * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_DOG
         * LIST_OF_REASONS_FOR_ADOPTING_DOG
         * LIST_OF_REASONS_FOR_ADOPTING_DOG
         * LIST_OF_VERIFIED_CYNOLOGISTS
         */
        public static final List<String> callbackQueryAfterCommandGroupHowTakeDog = new ArrayList<>(List.of(
                "HOW_TAKE_DOG",
                "START_BUTTON_FOR_EDIT_MESSAGE"
        ));

    }

    @Service
    public static class ButtonService {

        private final Logger logger = LoggerFactory.getLogger(ButtonService.class);

        /**
         * ArrayList c кнопками меню после команды "start"
         */
        public static final List<String> textButtonsAfterCommandStart = new ArrayList<>(List.of(
                "Приют для кошек ",
                "Приют для собак "
        ));

        /**
         * ArrayList c индификаторами кнопок меню после команды "start"
         */
        public static final List<String> callbackQueryAfterCommandStart = new ArrayList<>(List.of(
                "CHOOSE_A_SHELTER_CAT",
                "CHOOSE_A_SHELTER_DOG"
        ));

        private final TelegramBot telegramBot;

        public ButtonService(TelegramBot telegramBot) {
            this.telegramBot = telegramBot;
        }

        /**
         * Метод создает InlineKeyboardMarkup клавиатуру (в каждой строке одна кнопка)
         *
         * @param buttonsTexts    текст на кнопках
         * @param buttonsCallback идентификаторы кнопок
         * @return инлайн клавитура c кнопками
         */

        public InlineKeyboardMarkup prepareKeyboard(List<String> buttonsTexts, List<String> buttonsCallback) {

            //создаем клавиатуру
            InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

            //создаем список строк
            List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

            //в цикле:
            //создаем кнопки и добавляем их в строку, а строки в лист строк
            //за один проход цикла создается одна кнопка в каждой строке
            //количество кнопок определяется входящим параметром buttonsTexts (количеством записей)
            for (int i = 0; i < buttonsTexts.size(); i++) {
                List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                inlineKeyboardButton.setText(buttonsTexts.get(i));
                inlineKeyboardButton.setCallbackData(buttonsCallback.get(i));
                keyboardButtonsRow.add(inlineKeyboardButton);
                rowList.add(keyboardButtonsRow);
            }

            markupInline.setKeyboard(rowList);

            return markupInline;
        }
        /**
         * Метод отправляет пользователю сообщение с клавиатурой под сообщением
         *
         * @param chatId         идентификатор чата для отправки сообщения
         * @param messageText    текст сообщения
         * @param inlineKeyboard клавиатура под сообщением
         */

        /** responseStartButton отлаввливает сообщение старт и создает первое сообщение с клавиатурой,
         * далее кнопки обращаются к методу responseOnPressButton и он заменяет предыдущее сообщение новым с новой клавиатурой
         */
        public void responseStartButton(long chatId, String messageText, InlineKeyboardMarkup inlineKeyboard) {

            SendMessage sendMess = new SendMessage(String.valueOf(chatId), messageText);
            sendMess.setReplyMarkup(inlineKeyboard);
            try {
                telegramBot.execute(sendMess);
            } catch (TelegramApiException e) {
                logger.error("Произошла ошибка в методе responseStartButton: " + e.getMessage());
            }
        }

        public void responseOnPressButton(long chatId, long messageId, String messageText, InlineKeyboardMarkup inlineKeyboard) {

            EditMessageText sendMess = new EditMessageText();
            sendMess.setChatId(String.valueOf(chatId));
            sendMess.setText(messageText);
            sendMess.setMessageId((int)messageId);
            sendMess.setReplyMarkup(inlineKeyboard);
            try {
                telegramBot.execute(sendMess);
            } catch (TelegramApiException e) {
                logger.error("Произошла ошибка в методе responseOnPressButton: " + e.getMessage());
            }
        }
    }
}
