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
}
