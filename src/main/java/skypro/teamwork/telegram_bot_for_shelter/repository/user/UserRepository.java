package skypro.teamwork.telegram_bot_for_shelter.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.PhotoPetReport;
import skypro.teamwork.telegram_bot_for_shelter.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
