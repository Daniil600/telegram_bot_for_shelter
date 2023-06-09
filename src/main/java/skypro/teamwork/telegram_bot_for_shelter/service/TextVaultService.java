package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.stereotype.Service;

@Service
public class TextVaultService {

    /**
     * Тут хранится текст который будет выводиться пользователю при нажатии кнопки
     */

    /**
     * HISTORY_OF_SHELTER_CAT
     */
    public final String historyOfShelterCat = "В данном разделе должен храниться рассказ о  кошачьем приюте";


    /**
     * SCHEDULE_AND_ADDRESS_CAT
     */
    public final String scheduleAndAddressCat = "В данном разделе должна храниться информация " +
            "о расписании и адрессе приюта для кошек";


    /**
     *  CONTACT_SECURITY_CAT
     */
    public final String contactSecurityCat = "В данном разделе должна храниться информация " +
            "о контактных данных охраны для проеззда на территорию приюта для кошек";

    /**
     *  CONTACT_SECURITY_CAT
     */
    public final String recommendationLeafyCat = "В данном разделе должна храниться рекомендация " +
            "по технике безопасности на территории приюта для кошек";

    /**
     *  DATING_RULES_CAT
     */
    public final String datingRulesCat = "В данном разделе должны храниться правила знакомства с животным";

    /**
     *  LIST_OF_DOCUMENTS_FOR_ADOPTING_A_CAT
     */
    public final String listOfDocumentsForAdoptingCat = "В данном разделе должен храниться " +
            "список документов для опеки над питомцем";

    /**
     *  RECOMMENDATIONS_FOR_TRANSPORTATION_CAT
     */
    public final String recommendationsForTransportationCat = "В данном разделе должен храниться " +
            "список реккомендаций по транспортировке питомца";

    /**
     *  RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT
     */
    public final String recommendationsForHomeDesignForLittleCat = "В данном разделе должен храниться " +
            "список реккомендаций по обустройству дома для юного питомца";

    /**
     *  RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT
     */
    public final String recommendationsForHomeDesignForAdultCat = "В данном разделе должен храниться " +
            "список реккомендаций по обустройству дома для взрослого питомца";

    /**
     *  RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT
     */
    public final String recommendationsForHomeDesignForDisabledCat = "В данном разделе должен храниться " +
            "список реккомендаций по обустройству дома для питомца с ограниченными возможностями";

    /**
     *  LIST_OF_REASONS_FOR_ADOPTING_CAT
     */
    public final String listOfReasonForAdoptingCat = "В данном разделе должен храниться " +
            "список причин отказа в опеке питомца";
}
