package skypro.teamwork.telegram_bot_for_shelter.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skypro.teamwork.telegram_bot_for_shelter.model.user.User;

/**
 * репозиторий для хранения пользователей
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByChatId(Long chatId);
        }
