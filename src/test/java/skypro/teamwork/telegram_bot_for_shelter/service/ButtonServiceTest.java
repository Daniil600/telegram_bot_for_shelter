package skypro.teamwork.telegram_bot_for_shelter.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import skypro.teamwork.telegram_bot_for_shelter.service.function.button.ButtonService;

import java.util.ArrayList;
import java.util.List;

public class ButtonServiceTest {

    private final ButtonService buttonService = new ButtonService();

    @Test
    void prepareKeyboardTest() {
        List<String> textButtonsAfterCommand = new ArrayList<>(List.of(
                "Приют для кошек ",
                "Приют для собак "
        ));
        List<String> callbackQueryAfterCommand = new ArrayList<>(List.of(
                "cat",
                "dog"
        ));

        InlineKeyboardMarkup actual = buttonService.prepareKeyboard(textButtonsAfterCommand, callbackQueryAfterCommand);

        InlineKeyboardMarkup expected = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows= new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button1.setText("Приют для кошек ");
        button2.setText("Приют для собак ");
        button1.setCallbackData("cat");
        button2.setCallbackData("dog");
        row1.add(button1);
        row2.add(button2);
        rows.add(row1);
        rows.add(row2);
        expected.setKeyboard(rows);

        Assertions.assertThat(expected).isEqualTo(actual);

    }
}
