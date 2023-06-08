package skypro.teamwork.telegram_bot_for_shelter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

import java.util.List;


@Service
public class ButtonService {

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
            "cat",
            "dog"
    ));

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
            "CAT_1",
            "CAT_2",
            "CAT_3",
            "volunteer"
    ));

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
            "DOG_1",
            "DOG_2",
            "DOG_3",
            "volunteer"
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

    /** еще один вариант кода выше
    public InlineKeyboardMarkup prepareKeyboard(List<String> buttonsTexts, List<String> buttonsCallback) {
        List<List<InlineKeyboardButton>> rowList = buttonsTexts.stream()
                .map(text -> {
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText(text);
                    button.setCallbackData(buttonsCallback.get(buttonsTexts.indexOf(text)));
                    return button;
                })
                .map(Collections::singletonList)
                .collect(Collectors.toList());
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowList);
        return markupInline;
    }
     */


    /**
     * Метод отправляет пользователю сообщение с клавиатурой под сообщением
     *
     * @param chatId         идентификатор чата для отправки сообщения
     * @param messageText    текст сообщения
     * @param inlineKeyboard клавиатура под сообщением
     */
    public void responseOnPressButton(long chatId, String messageText, InlineKeyboardMarkup inlineKeyboard) {

        SendMessage sendMess = new SendMessage(String.valueOf(chatId), messageText);
        sendMess.setReplyMarkup(inlineKeyboard);
        try {
            telegramBot.execute(sendMess);
        } catch (TelegramApiException e) {
            logger.error("Произошла ошибка в методе responseOnPressButton: " + e.getMessage());
        }
    }
}
