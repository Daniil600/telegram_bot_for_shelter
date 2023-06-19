package skypro.teamwork.telegram_bot_for_shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class TelegramBotForShelterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotForShelterApplication.class, args);
    }

}
