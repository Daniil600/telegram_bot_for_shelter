package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.Cat;
import skypro.teamwork.telegram_bot_for_shelter.model.PhotoCats;

import java.util.Optional;

public interface PhotoCatsRepository extends JpaRepository<PhotoCats, Long> {
    Cat findPhotoCatsById(long catId);
}
