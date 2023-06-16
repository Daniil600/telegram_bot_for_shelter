package skypro.teamwork.telegram_bot_for_shelter.service.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.user.User;
import skypro.teamwork.telegram_bot_for_shelter.repository.user.UserRepository;
import skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.user.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserFunction {
    private static final Logger logger = LoggerFactory.getLogger(UserFunction.class);
private UserService userService;
    private final UserRepository userRepository;
    private static Map<Long, String> last_message = new HashMap<>();


    public UserFunction(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static Map<Long, String> getLast_message() {
        return last_message;
    }

    public static void setLastMessage(Long chat_id, String message) {
        if (chat_id != null && message != null) {
            last_message.put(chat_id, message);
        }
    }
    public static void last_message_clear() {
        last_message.clear();
    }
    public void saveUserInDB(Long chatId, Long id, String contact, String name) {
        User user = new User();
        user.setChatId(chatId);
        user.setId(id);
        user.setContact(contact);
        user.setName(name);

        userRepository.save(user);

        UserFunction.last_message_clear();
    }

}
