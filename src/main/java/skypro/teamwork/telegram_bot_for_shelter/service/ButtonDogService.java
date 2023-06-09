package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ButtonDogService {
    /**
     * ArrayList c кнопками меню после нажатия кнопки "dog"
     */
    public static final List<String> textButtonsAfterCommandDog = new ArrayList<>(List.of(
            "О приюте собак",
            "Как взять питомца из приюта",
            "Прислать отчет о питомце",
            "Позвать волонтёра"
    ));

    /**
     * ArrayList c индификаторами кнопок меню после нажатия кнопки "dog"
     */
    public static final List<String> callbackQueryAfterCommandDog = new ArrayList<>(List.of(
            "ABOUT_SHELTER_DOG",
            "HOW_TAKE_DOG",
            "SEND_REPORT_DOG",
            "VOLUNTEER"
    ));

}
