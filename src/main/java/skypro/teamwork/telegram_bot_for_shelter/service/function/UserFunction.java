package skypro.teamwork.telegram_bot_for_shelter.service.function;

import liquibase.pro.packaged.S;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.user.User;
import skypro.teamwork.telegram_bot_for_shelter.repository.user.UserRepository;
import skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.user.UserService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@Service
public class UserFunction {

    static class UserForMap{
        private LocalDateTime localDateTime;
        private String messageCommand;

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public String getMessageCommand() {
            return messageCommand;
        }

        public void setMessageCommand(String messageCommand) {
            this.messageCommand = messageCommand;
        }

        @Override
        public String toString() {
            return "UserForMap{" +
                    "localDateTime=" + localDateTime +
                    ", messageCommand='" + messageCommand + '\'' +
                    '}';
        }
    }

    private static long messageID;
    private UserService userService;
    private static Map<Long, UserForMap> last_message = new HashMap<>();


    public UserFunction(UserService userService) {
        this.userService = userService;
    }

    public static long getMessageID() {
        return messageID;
    }

    public static void setMessageID(long messageID) {
        UserFunction.messageID = messageID;
    }

    public static Map<Long, UserForMap> getLast_message() {
        return last_message;
    }

    public static void setLastMessage(Long chat_id,LocalDateTime localDateTime, String message) {
        if (chat_id != null && message != null) {
            UserForMap userForMap = new UserForMap();
            userForMap.setLocalDateTime(localDateTime);
            userForMap.setMessageCommand(message);
            last_message.put(chat_id, userForMap);
        }
    }

    public static void last_message_clear(Long chatId) {
        last_message.entrySet().removeIf(entry -> entry.getKey().equals(chatId));
    }

    public void saveUserInDB(Long chatId, String contact, String name) {
        User user = new User();
        user.setChatId(chatId);
        user.setContact(contact);
        user.setName(name);

        userService.addUser(user);
    }

}