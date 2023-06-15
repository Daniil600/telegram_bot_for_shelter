package skypro.teamwork.telegram_bot_for_shelter.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Update;
import skypro.teamwork.telegram_bot_for_shelter.exceptions.UploadFileException;
import skypro.teamwork.telegram_bot_for_shelter.model.AppDocument;
import skypro.teamwork.telegram_bot_for_shelter.model.BinaryContent;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.PhotoPetReport;
import skypro.teamwork.telegram_bot_for_shelter.repository.AppDocumentRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.BinaryContentRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class FileServiceImpl implements FileService {
    @Value("${bot.token}")
    private String token;
    @Value("${service.file_info.uri}")
    private String fileInfoUri;
    @Value("${service.file_storage.uri}")
    private String fileStorageUri;
    private final AppDocumentRepository appDocumentRepository;
    private final BinaryContentRepository binaryContentRepository;

    public FileServiceImpl(AppDocumentRepository appDocumentRepository, BinaryContentRepository binaryContentRepository) {
        this.appDocumentRepository = appDocumentRepository;
        this.binaryContentRepository = binaryContentRepository;
    }

    @Override
    public AppDocument processDoc(Update update) {
        String fileId = update.getMessage().getPhoto().get(2).getFileId();
        ResponseEntity<String> response = getFilePath(fileId);
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            String filePath = String.valueOf(jsonObject
                    .getJSONObject("result")
                    .getString("file_path"));
            byte[] fileInByte = downloadFile(filePath);
            BinaryContent transientBinaryContent = BinaryContent.builder()
                    .fileAsArrayOfBytes(fileInByte)
                    .build();

            PhotoPetReport report =
                    new PhotoPetReport(1L,filePath,update.getMessage().getPhoto().get(0).getFileSize(),)




            BinaryContent persistentBinaryContent = binaryContentRepository.save(transientBinaryContent);
            Document telegramDoc = update.getMessage().getDocument();
            AppDocument transientAppDoc = buildTransientAppDoc(telegramDoc, persistentBinaryContent);
            return appDocumentRepository.save(transientAppDoc);
        } else {
            throw new UploadFileException("Bad response from telegram service: " + response);
        }
    }

    private AppDocument buildTransientAppDoc(Document telegramDoc, BinaryContent persistentBinaryContent) {
        return AppDocument.builder()
                .telegramFileId(telegramDoc.getFileId())
                .docName(telegramDoc.getFileName())
                .binaryContent(persistentBinaryContent)
                .mimeType(telegramDoc.getMimeType())
                .fileSize(Long.valueOf(telegramDoc.getFileSize()))
                .build();
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

        try (InputStream is = urlObj.openStream()) {
            return is.readAllBytes();
        } catch (IOException e) {
            throw new UploadFileException(urlObj.toExternalForm(), e);
        }
    }
}
