package skypro.teamwork.telegram_bot_for_shelter.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import skypro.teamwork.telegram_bot_for_shelter.model.AppDocument;

public interface FileService {
    AppDocument processDoc(Update update);
}