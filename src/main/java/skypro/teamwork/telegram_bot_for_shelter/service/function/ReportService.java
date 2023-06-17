package skypro.teamwork.telegram_bot_for_shelter.service.function;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.*;
import skypro.teamwork.telegram_bot_for_shelter.exceptions.UploadFileException;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.PhotoPetReport;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PetRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PhotoPetReportRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.ReportPetRepository;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    private final PetRepository petRepository;
    private final PhotoPetReportRepository photoPetReportRepository;
    private final ReportPetRepository reportPetRepository;


    public String petPassport;
    public String textReport;

    @Value("${bot.token}")
    private String token;
    @Value("${service.file_info.uri}")
    private String fileInfoUri;
    @Value("${service.file_storage.uri}")
    private String fileStorageUri;

    public Map<Long, Integer> activeReportUsers = new HashMap(Map.of());

    public ReportService(PetRepository petRepository,  PhotoPetReportRepository photoPetReportRepository, ReportPetRepository reportPetRepository) {
        this.petRepository = petRepository;
        this.photoPetReportRepository = photoPetReportRepository;
        this.reportPetRepository = reportPetRepository;
    }

    /*
    activeReportCheck  -это метод, который проверяет, что пользователь находится в состоянии сдачи отчета
    об опеке и записывает его в activeReportUsers. Этот метод также удаляет пользователя из activeReportUsers,
    если он завершает сдачу отчета.
     */
    public void activeReportCheck(long chatId) {
        logger.info("Вызван метод обработки отчета пользователя об опеке");
        int countMessage = 1;

        if (activeReportUsers.containsKey(chatId) == false) {
            activeReportUsers.put(chatId, countMessage);
            logger.info("Пользователь в данный момент не в режиме сдачи отчета," +
                    " создается упоминание что он нажал кнопку сдачи отчета");

        } else if (activeReportUsers.containsKey(chatId) && activeReportUsers.get(chatId) > 1) {
            activeReportUsers.put(chatId, activeReportUsers.get(chatId) - 1);
            logger.info("Проверка количества сообщений написанных пользователем не превышает лимит");
        } else if (activeReportUsers.containsKey(chatId) && activeReportUsers.get(chatId) == 1) {
            activeReportUsers.remove(chatId);
            logger.info("Последнее сообщение лимита, пользователь выводится из режима сдачи отчета");
        }
    }

    public void processDoc(Update update) {
        String fileId = update.getMessage().getPhoto().get(2).getFileId();
        ResponseEntity<String> response = getFilePath(fileId);
        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            String filePath = String.valueOf(jsonObject.getJSONObject("result").getString("file_path"));
            byte[] fileInByte = downloadFile(filePath);
            textReport = update.getMessage().getCaption();
            petPassport = extractPetPassport(update.getMessage().getCaption());

            // создаем объект reportPet и сохраняем его в базе данных
            ReportPet reportPet = new ReportPet();
            Pet pet = petRepository.findByPetPassport(petPassport);
            reportPet.setRept(textReport);
            reportPet.setPet(pet);
            reportPetRepository.save(reportPet);

            // создаем объект PhotoPetReport и устанавливаем свойства, включая reportPet
            PhotoPetReport photoPetReport = new PhotoPetReport();
            photoPetReport.setFilePath(filePath);
            photoPetReport.setFileSize(update.getMessage().getPhoto().get(2).getFileSize());
            photoPetReport.setMediaType("photo");
            photoPetReport.setData(fileInByte);
            photoPetReport.setReportPet(reportPet);
            photoPetReportRepository.save(photoPetReport);

            reportPet.setPhotoPetsReport(photoPetReport);
            logger.info(update.getMessage().getCaption());
        }
    }

    public static String extractPetPassport(String incomeText) {
        Pattern pattern = Pattern.compile("(\\d{6})\\s(.*)");
        Matcher matcher = pattern.matcher(incomeText);

        if (matcher.matches()) {
            String passport = matcher.group(1);
            logger.info(passport);
            return passport;

        } else {
            throw new IllegalArgumentException("String does not match format");
        }

    }

    public ResponseEntity<String> getFilePath(String fileId) {
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

    public byte[] downloadFile(String filePath) {
        String fullUri = fileStorageUri.replace("{bot.token}", token)
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