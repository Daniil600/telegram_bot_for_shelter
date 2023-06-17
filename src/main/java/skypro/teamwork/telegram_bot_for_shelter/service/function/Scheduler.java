package skypro.teamwork.telegram_bot_for_shelter.service.function;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.ReportPetRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class Scheduler {
    private final TelegramBot telegramBot;
    private final ReportPetRepository reportPetRepository;

    public Scheduler(TelegramBot telegramBot, ReportPetRepository reportPetRepository) {
        this.telegramBot = telegramBot;
        this.reportPetRepository = reportPetRepository;
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void sendNotification() {
        List<ReportPet> reportPets = reportPetRepository.findAllByDate(LocalDate.now().minusDays(1)); // здесь нужно изменить код так, чтобы из базы выбирались только последние отчеты пользователя, и только те, у кого испытательный срок еще не прошел
        reportPets.forEach(r -> {
            telegramBot.sendMessage(r.getPet().getUser().getChatId(), "Напоминание: сегодня Вам необходимо отправить отчет о состоянии питомца");
        });
    }
}
