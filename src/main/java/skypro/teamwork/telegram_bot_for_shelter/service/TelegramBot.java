package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import skypro.teamwork.telegram_bot_for_shelter.config.BotConfig;

@Component
/** Данный класс наследуется из TelegramLongPollingBot и переопределяет методы в конструкторе
 * для взаимодействия нашей программы с ботом через класс BotConfig,
 * в котором имеются геттеры созданные библиотекой ломбок */
public class TelegramBot extends TelegramLongPollingBot {

    /**
     * Инициализация класса, в котором хранится имя и токен бота
     */
    private final BotConfig config;
    private final BotService botService;

    public TelegramBot(BotConfig config, BotService botService) {
        this.config = config;
        this.botService = botService;
    }

    /**
     * Переопределение методов под наши задачи из класса TelegramLongPollingBot
     */
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    /**
     * Данный метод отслеживает какое сообщение пришло от пользователя в update и выполняет функционал взависимости
     * от полученного сообщения путем свитч кейс
     */
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();


            switch (messageText) {
                case "/start":
                    botService.startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;

                default:
                    sendMessage(chatId, "Поторите попытку, такой комманды нет!"
                            + "\nНажмите на /start для начала общения с ботом");
                    break;
            }

        } else if (update.hasCallbackQuery()) {
            String callbackQuery = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            String firstName = update.getCallbackQuery().getFrom().getFirstName();

            switch (callbackQuery) {
                /** кпопки первого уровня*/
                case "START_BUTTON_FOR_EDIT_MESSAGE":
                    botService.startCommandReceivedForEditMessage
                            (chatId, messageId, firstName);
                    break;


                /** кпопки второго уровня*/
                case "CHOOSE_A_SHELTER_CAT":
                    botService.responseOnPressButtonCat(chatId, messageId);
                    break;
                case "CHOOSE_A_SHELTER_DOG":
                    botService.responseOnPressButtonDog(chatId, messageId);
                    break;


                /** кнопка Рассказ о приюте и ее подкнопки кошки*/
                case "ABOUT_SHELTER_CAT":
                    botService.responseOnPressButtonAboutShelterCat(chatId, messageId);
                    break;
                case "HISTORY_OF_SHELTER_CAT":
                    botService.responseOnPressButtonHistoryOfShelterCat(chatId, messageId);
                    break;
                case "SCHEDULE_AND_ADDRESS_CAT":
                    botService.responseOnPressButtonScheduleAndAddressCat(chatId, messageId);
                    break;
                case "CONTACT_SECURITY_CAT":
                    botService.responseOnPressButtonContactSecurityCat(chatId, messageId);
                    break;
                case "RECOMMENDATION_LEAFY_CAT":
                    botService.responseOnPressButtonRecommendationLeafyCat(chatId, messageId);
                    break;


                /** кнопка Рассказ о приюте и ее подкнопки собаки*/
                case "ABOUT_SHELTER_DOG":
                    botService.responseOnPressButtonAboutShelterDog(chatId, messageId);
                    break;
                case "HISTORY_OF_SHELTER_DOG":
                    botService.responseOnPressButtonHistoryOfShelterDog(chatId, messageId);
                    break;
                case "SCHEDULE_AND_ADDRESS_DOG":
                    botService.responseOnPressButtonScheduleAndAddressDog(chatId, messageId);
                    break;
                case "CONTACT_SECURITY_DOG":
                    botService.responseOnPressButtonContactSecurityDog(chatId, messageId);
                    break;
                case "RECOMMENDATION_LEAFY_DOG":
                    botService.responseOnPressButtonRecommendationLeafyDog(chatId, messageId);
                    break;


                /** кнопка Как взять питомца из приюта и ее подкнопки кошки*/
                case "HOW_TAKE_CAT":
                    botService.responseOnPressButtonHowTakeCat(chatId, messageId);
                    break;
                case "DATING_RULES_CAT":
                    botService.responseOnPressButtonDatingRulesCat(chatId, messageId);
                    break;
                case "LIST_OF_DOCUMENTS_FOR_ADOPTING_CAT":
                    botService.responseOnPressButtonListOfDocumentsForAdoptingCat(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_TRANSPORTATION_CAT":
                    botService.responseOnPressButtonRecommendationsForTransportationCat(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_CAT":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForLittleCat(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_CAT":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForAdultCat(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_CAT":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForDisabledCat(chatId, messageId);
                    break;
                case "LIST_OF_REASONS_FOR_ADOPTING_CAT":
                    botService.responseOnPressButtonListOfReasonForAdoptingCat(chatId, messageId);
                    break;


                /** кнопка Как взять питомца из приюта и ее подкнопки собаки*/
                case "HOW_TAKE_DOG":
                    botService.responseOnPressButtonHowTakeDog(chatId, messageId);
                    break;
                case "DATING_RULES_DOG":
                    botService.responseOnPressButtonDatingRulesDog(chatId, messageId);
                    break;
                case "LIST_OF_DOCUMENTS_FOR_ADOPTING_DOG":
                    botService.responseOnPressButtonListOfDocumentsForAdoptingDog(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_TRANSPORTATION_DOG":
                    botService.responseOnPressButtonRecommendationsForTransportationDog(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_LITTLE_DOG":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForLittleDog(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_ADULT_DOG":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForAdultDog(chatId, messageId);
                    break;
                case "RECOMMENDATIONS_FOR_HOME_DESIGN_FOR_DISABLED_DOG":
                    botService.responseOnPressButtonRecommendationsForHomeDesignForDisabledDog(chatId, messageId);
                    break;
                case "LIST_OF_REASONS_FOR_ADOPTING_DOG":
                    botService.responseOnPressButtonListOfReasonForAdoptingDog(chatId, messageId);
                    break;
                case "LIST_OF_VERIFIED_CYNOLOGISTS_DOG":
                    botService.responseOnPressButtonListOfVerifiedCynologistDog(chatId, messageId);
                    break;
                case "CYNOLOGISTS_ADVICE_DOG":
                    botService.responseOnPressButtonCynologistAdviceDog(chatId, messageId);
                    break;


                case "SEND_REPORT_CAT":
                case "SEND_REPORT_DOG":
                    sendMessage(chatId, "Раздел в стадии разработки, " +
                            "тут вы сможете отправить отчет о том как питомец себя чувствует на новом месте");
                    break;

                case "TAKE_CONTACT_FOR_FEEDBACK":
                    sendMessage(chatId, "Раздел в стадии разработки, " +
                            "тут вы сможете оставить свои данные для передачи их волонтеру");
                    break;
                case "VOLUNTEER":
                    sendMessage(chatId, "Раздел в стадии разработки, тут вы сможете связаться с волонтером");
                    break;
                default:
                    sendMessage(chatId, "Поторите попытку, такой комманды нет");
                    break;
            }
        }

    }

    /**
     * Данный метод получает входящие данные и несет в себе функционал отправки их пользователю
     */
    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e) {

        }
    }
}
