package skypro.teamwork.telegram_bot_for_shelter.service.function;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.*;
import skypro.teamwork.telegram_bot_for_shelter.service.FileService;


import java.util.*;

@Service
public class ReportService {
    private final Logger logger = LoggerFactory.getLogger(ReportService.class);

    private final FileService fileService;


    @Value("${bot.token}")
    private String token;
    @Value("${service.file_info.uri}")
    private String fileInfoUri;
    @Value("${service.file_storage.uri}")
    private String fileStorageUri;

    public Map<Long, Integer> activeReportUsers = new HashMap(Map.of());

    public ReportService(FileService fileService) {
        this.fileService = fileService;
    }

    public void activeReportCheck(long chatId) {
        logger.info("Вызван метод обработки отчета пользователя об опеке");
        int countMessage = 3;

        if (activeReportUsers.containsKey(chatId) == false) {
            activeReportUsers.put(chatId, countMessage);
            logger.info("Пользователь был не найден, создается упоминание что он нажал кнопку сдачи отчета");
        } else if (activeReportUsers.containsKey(chatId) && activeReportUsers.get(chatId) > 1) {
            activeReportUsers.put(chatId, activeReportUsers.get(chatId) - 1);
            logger.info("Проверка количества сообщений написанных пользователем не превышает лимит");
        } else if (activeReportUsers.containsKey(chatId) && activeReportUsers.get(chatId) == 1) {
            activeReportUsers.remove(chatId);
            logger.info("Последнее сообщение лимита, пользователь выводится из режима сдачи отчета");
        }
    }

    public void reportMessageChecker(Update update) {
        fileService.processDoc(update);
    }



}
