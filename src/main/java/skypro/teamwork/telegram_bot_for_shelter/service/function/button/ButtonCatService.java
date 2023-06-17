package skypro.teamwork.telegram_bot_for_shelter.service.function.button;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonCatService {
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
     * ArrayList c идентификаторами кнопок меню после нажатия кнопки "CHOOSE_A_SHELTER_CAT"
     */
    public static final List<String> callbackQueryAfterCommandCat = new ArrayList<>(List.of(
            "ABOUT_SHELTER_CAT",
            "HOW_TAKE_CAT",
            "SEND_REPORT_CAT",
            "VOLUNTEER",
            "START_BUTTON_FOR_EDIT_MESSAGE"
    ));

     /*
       - HashMap c кнопками меню и идентификаторами кнопок меню после нажатия кнопки "CHOOSE_A_SHELTER_CAT"

    public static final Map<String, String> textButtonsAfterCommandCat = new HashMap<String, String>() {{
        put("О приюте кошек", "ABOUT_SHELTER_CAT");
        put("Как взять питомца из приюта", "HOW_TAKE_CAT");
        put("Прислать отчет о питомце", "SEND_REPORT_CAT");
        put("Позвать волонтёра", "VOLUNTEER");
        put("Назад", "START_BUTTON_FOR_EDIT_MESSAGE");
    }};*/


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
     * ArrayList c идентификаторами кнопок меню после нажатия кнопки "ABOUT_SHELTER_CAT"
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


    /*
       * HashMap c кнопками меню и идентификаторами кнопок меню после нажатия кнопки "ABOUT_SHELTER_CAT"

    public static final Map<String, String> textButtonsAfterCommandAboutShelterCat = new HashMap<String, String>() {{
        put("Рассказ о приюте", "HISTORY_OF_SHELTER_CAT");
        put("Расписание и адрес", "SCHEDULE_AND_ADDRESS_CAT");
        put("Контактные данные охраны", "CONTACT_SECURITY_CAT");
        put("Рекомандация по технике безопасности на территории", "RECOMMENDATION_LEAFY_CAT");
        put("Принять контактные данные для связи", "TAKE_CONTACT_FOR_FEEDBACK");
        put("Вызвать волонтёра", "VOLUNTEER");
        put("Назад", "CHOOSE_A_SHELTER_CAT");
    }};*/

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
     * ArrayList c идентификаторами кнопок меню после нажатия кнопки "HOW_TAKE_CAT"
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

    /*
       * HashMap c кнопками меню и идентификаторами кнопок меню после нажатия кнопки "HOW_TAKE_CAT"

    public static final Map<String, String> textButtonsAfterCommandHowTakeCat = new HashMap<String, String>() {{
        put("Правила знакомства с животным", "DATING_RULES_CAT");
        put("Список документов для опеки", "LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT");
        put("Рекоммендации по транспортировке", "RECOMMENDATIONS_FOR_TRANSPORTATION_CAT");
        put("Рекомандации по обустройству дома для юного питомца", "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT");
        put("Рекомандации по обустройству дома для взрослого питомца", "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT");
        put("Рекомандации по обустройству дома для питомца с ограниченными возможностями", "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT");
        put("Список причин отказа в опеке", "LIST_OF_REASONS_FOR_ADOPTING_CAT");
        put("Принять контактные данные для связи", "TAKE_CONTACT_FOR_FEEDBACK");
        put("Вызвать волонтёра", "VOLUNTEER");
        put("Назад", "CHOOSE_A_SHELTER_CAT");
    }};*/


    /**
     * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  "ABOUT_SHELTER_CAT"
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
     * ArrayList c идентификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  "ABOUT_SHELTER_CAT"
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

    /*
     * HashMap c кнопками меню и идентификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой "ABOUT_SHELTER_CAT"
     * список кнопок
     * HISTORY_OF_SHELTER_CAT
     * SCHEDULE_AND_ADDRESS_CAT
     * CONTACT_SECURITY_CAT
     * RECOMMENDATION_LEAFY_CAT"

    public static final Map<String, String> textButtonsAfterCommandGroupAboutShelterCat = new HashMap<String, String>() {{
        put("Назад", "ABOUT_SHELTER_CAT");
        put("Вернуться в начало", "START_BUTTON_FOR_EDIT_MESSAGE");
    }};*/


    /**
     * ArrayList c кнопками меню после нажатия кнопок выдаваемых кнопкой  "HOW_TAKE_CAT"
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
     * ArrayList c идентификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой  "HOW_TAKE_CAT"
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

    /*
     * HashMap c кнопками меню и идентификаторами кнопок меню после нажатия кнопок выдаваемых кнопкой "HOW_TAKE_CAT"
     * список кнопок
     * DATING_RULES_CAT
     * LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT
     * RECOMMENDATIONS_FOR_TRANSPORTATION_CAT
     * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT
     * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT
     * RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT
     * LIST_OF_REASONS_FOR_ADOPTING_CAT

    public static final Map<String, String> textButtonsAfterCommandGroupHowTakeCat = new HashMap<String, String>() {{
        put("Назад", "HOW_TAKE_CAT");
        put("Вернуться в начало", "START_BUTTON_FOR_EDIT_MESSAGE");
    }};*/
}