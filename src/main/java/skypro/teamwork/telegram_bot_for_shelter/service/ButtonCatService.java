package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonCatService {
    /**
     * ArrayList c кнопками меню после нажатия кнопки "cat"
     */
    public static final List<String> textButtonsAfterCommandCat = new ArrayList<>(List.of(
            "О приюте кошек",
            "Как взять питомца из приюта",
            "Прислать отчет о питомце",
            "Позвать волонтёра"
    ));

    /**
     * ArrayList c индификаторами кнопок меню после нажатия кнопки "cat"
     */
    public static final List<String> callbackQueryAfterCommandCat = new ArrayList<>(List.of(
            "ABOUT_SHELTER_CAT",
            "HOW_TAKE_CAT",
            "SEND_REPORT_CAT",
            "VOLUNTEER"
    ));


    public static final List<String> textButtonsAfterCommandInfoShelter = new ArrayList<>(List.of(
            "Рассказ о приюте",
            "Расписание и адрес",
            "Контактные данные охраны",
            "Рекомандация по технике безопасности на территории",
            "Принять контактные данные для связи",
            "Вызвать волонтёра"
    ));

    /**
     * ArrayList c индификаторами кнопок меню после нажатия кнопки "cat"
     */
    public static final List<String> callbackQueryAfterCommandInfoShelter = new ArrayList<>(List.of(
            "HISTORY_OF_SHELTER_CAT",
            "SCHEDULE_AND_ADDRESS_CAT",
            "CONTACT_SECURITY_CAT",
            "RECOMMENDATION_LEAFY_CAT",
            "TAKE_CONTACT_FOR_FEATBACK_CAT",
            "VOLUNTEER"
    ));

}
