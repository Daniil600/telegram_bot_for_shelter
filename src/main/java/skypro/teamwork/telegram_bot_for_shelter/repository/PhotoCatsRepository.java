package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.Cat;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.PhotoCats;

public interface PhotoCatsRepository extends JpaRepository<PhotoCats, Long> {
    Cat findPhotoCatsById(long catId);
}
