package skypro.teamwork.telegram_bot_for_shelter.service.function;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import skypro.teamwork.telegram_bot_for_shelter.exceptions.UploadFileException;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class ReportService {
    private final Logger logger = LoggerFactory.getLogger(ReportService.class);
    @Value("${bot.token}")
    private String token;
    @Value("${service.file_info.uri}")
    private String fileInfoUri;
    @Value("${service.file_storage.uri}")
    private String fileStorageUri;

    public Map<Long, Integer> activeReportUsers = new HashMap(Map.of());

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

    /*public void reportMessageChecker(Update update) {
        getFilePhoto(update);
    }

    public void getFilePhoto(Update update) {
        String fileId = update.getMessage().getPhoto().get(0).getFileId();
        ResponseEntity<String> response = getFilePath(fileId);
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            String filePath = String.valueOf(jsonObject
                    .getJSONObject("result")
                    .getString("file_path"));
            byte[] fileInByte = downloadFile(filePath);
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(String.valueOf(update.getMessage().getChatId()));
            sendPhoto.setPhoto(fileInByte);

        }
    }

    private ResponseEntity<String> getFilePath(String fileId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        return restTemplate.exchange(
                fileInfoUri,
                HttpMethod.GET,
                request,
                String.class,
                token, fileId
        );
    }

    private byte[] downloadFile(String filePath) {
        String fullUri = fileStorageUri.replace("{token}", token)
                .replace("{filePath}", filePath);
        URL urlObj = null;
        try {
            urlObj = new URL(fullUri);
        } catch (MalformedURLException e) {
            throw new UploadFileException(e);
        }

        //TODO подумать над оптимизацией
        try (InputStream is = urlObj.openStream()) {
            return is.readAllBytes();
        } catch (IOException e) {
            throw new UploadFileException(urlObj.toExternalForm(), e);
        }
    }*/


}
