package skypro.teamwork.telegram_bot_for_shelter.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")

/** Данный класс хранит в себе токен и имя бота для того, чтобы их можно было запрашивать из методов с помощью геттеров
 * аннотация @Data у нас из зависимости ломбок, она собственно и создает конструктор в методе */

public class BotConfig {
   @Value("${bot.name}")
    String botName;
   @Value("${bot.token}")
    String token;
}