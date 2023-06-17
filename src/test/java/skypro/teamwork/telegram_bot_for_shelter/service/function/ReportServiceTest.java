package skypro.teamwork.telegram_bot_for_shelter.service.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.PhotoPetReport;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PetRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PhotoPetReportRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.ReportPetRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static skypro.teamwork.telegram_bot_for_shelter.service.function.ReportService.extractPetPassport;

@ContextConfiguration(classes = {ReportService.class})
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class ReportServiceTest {

    // Навешиваю зависимости
    @MockBean
    private PetRepository petRepository;

    @MockBean
    private PhotoPetReportRepository photoPetReportRepository;

    @MockBean
    private ReportPetRepository reportPetRepository;

    @Autowired
    private ReportService reportService;


    // Эту аннотацию использую, чтобы каждый раз создавать объект reportService перед каждым запуском метода теста
    @BeforeEach
    void setUp() {
        reportService = new ReportService(petRepository, photoPetReportRepository, reportPetRepository);
    }


    /* Это тест проверяет функциональность метда activeReportCheck.
         Первый assert проверяет, что до вызова метода activeReportCheck, поле activeReportUsers, в HashMap отчета, пустое.
         Затем, метод activeReportCheck вызывается и передает ему chatId.
         А следующие два assert проверяют, что после вызова метода activeReportCheck, поле activeReportUsers содержит chatId как
         ключ и значчение этого ключа равно 1.
         Короч тест проверяет коректность работы метода activeReportCheck при создании нового чатаОтчета в поле
         activeReportUsers с chatId в качестве ключа. */
    @Test
    public void activeReportCheck_newUser() {
        long chatId = 1L;
        assertThat(reportService.activeReportUsers).isEmpty();
        reportService.activeReportCheck(chatId);
        assertThat(reportService.activeReportUsers).containsKey(chatId);
        assertThat(reportService.activeReportUsers).containsValue(1);
    }


    /* Этот тест проверяет метод activeReportCheck,
    который, используется для проверки активных отчетов юзеров в чате.
    Вначалле Тест проверяет что список пуст.
    Затем вызывается метод activeReportCheck(chatId) двараза, который
    должен добавлять юзера в спсок активных отчетов.
    Дальше тест снова проверяет что список activeReportUsers все еще пуст.
    Крч этот тест проверяет, что метод activeReportCheck правильно добавляет юзера в
    список активных отчетов, и что список имеющихся отчетов корректно очищается после завершения метода. */
    @Test
    public void activeReportCheck_userOneMessage() {
        long chatId = 1L;
        assertThat(reportService.activeReportUsers).isEmpty();
        reportService.activeReportCheck(chatId);
        reportService.activeReportCheck(chatId);
        assertThat(reportService.activeReportUsers).isEmpty();
    }

    /* этот тест проверяет, что метод activeReportCheck коректно добавляет юзера
    в список активных отчетов и закрепляет нужное колличество сообщений для юзера в списке. */
    @Test
    public void activeReportCheck_userMultipleMessages() {
        long chatId = 1L;
        assertThat(reportService.activeReportUsers).isEmpty();
        reportService.activeReportCheck(chatId);
        reportService.activeReportCheck(chatId);
        reportService.activeReportCheck(chatId);
        assertThat(reportService.activeReportUsers).containsKey(chatId);
        assertThat(reportService.activeReportUsers).containsValue(1);
    }

    /*   Этот тетс, создается Update объект, который имитирует корректное
    сообщения от бота Telegram. Затем выполняется метод processDoc() и проводится проверка, были ли
    правильно вызваны методы petRepository, reportPetRepository и photoPetReportRepository,
    используемые в этом методе*/
//    @Test
//    public void processDoc_validUpdate() {
//
//        // Входные параметры (сообщение от телеграм бота )
//        String fileId = "test_file_id";
//        String filePath = "test_file_path";
//        String petPassport = "test_pet_passport";
//        String textReport = "test_text_report";
//        int fileSize = 100;
//        byte[] fileInByte = new byte[1024];
//
//        // Создаю объект update и все необходимые моки
//        Update update = new Update();
//        Message message = mock(Message.class);
//        PhotoSize photoSize = mock(PhotoSize.class);
//
//        // Указываю, какие значения должен вернуть мок Message в той или иной ситуацци
//        when(message.getCaption()).thenReturn(textReport);
//
//        when(petRepository.findByPetPassport(petPassport)).thenReturn(new Pet());
//        when(photoSize.getFileSize()).thenReturn(fileSize);
//
//        when(message.getPhoto()).thenReturn(Arrays.asList(mock(PhotoSize.class), mock(PhotoSize.class), photoSize));
//
//        // Подвязываю к объекту update, объект message
//        update.setMessage(message);
//
//        // Создаю ResponseEntity с заливаю в него URI, куда потом вернется ответ.
//        // ??? ВОПРОС КОЛЛЕГАМ КОКОЙ ЮРЛ УКАЗАТЬ В 149 строчке????
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "${service.file_info.uri}", HttpStatus.OK);
//
//        // !!! ВАЖНО!!! ПРИМЕЧАНИЕ ДЛЯ КОЛЛЕГ изменил модификаторы доступа у методов getFilePath и downloadFile с Прайвед на Паблик
//        // Указываю, какие значения должен вернуть сервис reportService при вызовах getFilePath и downloadFile
//        when(reportService.getFilePath(fileId)).thenReturn(response);
//        when(reportService.downloadFile(filePath)).thenReturn(fileInByte);
//
//        // действие (вызываю метод processDoc)
//        reportService.processDoc(update);
//
//        // Проверяю были ли правильно вызваны методы petRepository reportPetRepository и photoPetReportRepository
//        verify(petRepository, times(1)).findByPetPassport(petPassport);
//        verify(reportPetRepository, times(1)).save(any(ReportPet.class));
//        verify(photoPetReportRepository, times(1)).save(any(PhotoPetReport.class));
//    }


    /*
    Тест создается неверный объект Update, который не содержит сообщения. Затем выполняется метод
    processDoc и проверяется, было ли брошено исключение НулПоинтерЭксепшен в результате попытки
    вызвать методы на null объектах.
    Также в этом тесте проверяется что ни какие методы репозиторев не были вызваны
     */
    @Test
    public void processDoc_invalidUpdate() {

        // Входные параметры (создаем неверный обьект который не содержит сообщения)
        Update update = new Update();
        update.setMessage(null);

        // действия ( вызываем метод processDoc и проверяем был ли брошен НулПоинтерЭксепшен)
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            reportService.processDoc(update);
        });

        // проверка выполнения
        assertNotNull(exception);
        assertEquals(null,
                exception.getMessage());

        // использую verify чтоб убедиться что никакие методы репозиториев не были вызваны,
        // так как обработка была прервана до их вызова.
        verify(petRepository, never()).findByPetPassport(anyString());
        verify(reportPetRepository, never()).save(any(ReportPet.class));
        verify(photoPetReportRepository, never()).save(any(PhotoPetReport.class));
    }

    // Тест проверяет, что метод правильно извлекает паспорт из строки в правильном форматее
    @Test
    void shouldReturnPetPassport() {
        // вХОДНЫЕ ДАННЫЕ
        String input = "123456 Some text";
        String expectedOutput = "123456";

        // Актуальные
        String actualOutput = extractPetPassport(input);

        // Проверка
        assertEquals(expectedOutput, actualOutput);
    }

    /* тест проверяет, что метод выбрасывает эксепшенIllegalArgumentException при попытке проверить строку,
     которая не соответствует формату вввода.*/
    @Test
    void testExtractPetPassport_exception() {
        // Верный ввод
        String input1 = "123456 Бла-бла-бла";
        String output1 = "123456";
        assertEquals(output1, extractPetPassport(input1));

        // Неверный Ввод
        String input2 = "Некоректный текст";
        assertThrows(IllegalArgumentException.class, () -> extractPetPassport(input2));
    }
}