package skypro.teamwork.telegram_bot_for_shelter.service.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import skypro.teamwork.telegram_bot_for_shelter.config.BotConfig;
import skypro.teamwork.telegram_bot_for_shelter.service.function.button.ButtonService;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import static org.mockito.Mockito.*;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TelegramBotTest {

    @Mock
    private ButtonService buttonService;


    @InjectMocks
    private BotService botService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStartCommandReceived() {
        long chatId = 123;
        String name = "John";
        InlineKeyboardMarkup inlineKeyboard = mock(InlineKeyboardMarkup.class);
        when(buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandStart,
                ButtonService.callbackQueryAfterCommandStart)).thenReturn(inlineKeyboard);

        botService.startCommandReceived(chatId, name);

        verify(buttonService).responseStartButton(chatId, "Добрый день " + name +
                "\nВыберите интересующий Вас приют", inlineKeyboard);
    }

    @Test
    public void testStartCommandReceivedForEditMessage() {
        long chatId = 123;
        long messageId = 456;
        String name = "John";
        InlineKeyboardMarkup inlineKeyboard = mock(InlineKeyboardMarkup.class);
        when(buttonService.prepareKeyboard(
                ButtonService.textButtonsAfterCommandStart,
                ButtonService.callbackQueryAfterCommandStart)).thenReturn(inlineKeyboard);

        botService.startCommandReceivedForEditMessage(chatId, messageId, name);

        verify(buttonService).responseOnPressButton(chatId, messageId, "Добрый день " + name +
                "\nВыберите интересующий Вас приют", inlineKeyboard);
    }
    @Test
    public void testOnUpdateReceived() {
        BotConfig botConfig = Mockito.mock(BotConfig.class);
        BotService botService = Mockito.mock(BotService.class);

        TelegramBot telegramBot = new TelegramBot(botConfig, botService);

        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getText()).thenReturn("/start");
        Chat chat = Mockito.mock(Chat.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(message.getChat()).thenReturn(chat);
        Mockito.when(chat.getFirstName()).thenReturn("John");
        Update update = Mockito.mock(Update.class);
        Mockito.when(update.hasMessage()).thenReturn(true);
        Mockito.when(update.getMessage()).thenReturn(message);

        telegramBot.onUpdateReceived(update);

        Mockito.verify(botService).startCommandReceived(ArgumentMatchers.anyLong(), ArgumentMatchers.nullable(String.class));
    }
}

