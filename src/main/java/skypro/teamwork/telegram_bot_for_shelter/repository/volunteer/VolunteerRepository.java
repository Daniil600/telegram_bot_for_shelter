package skypro.teamwork.telegram_bot_for_shelter.repository.volunteer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skypro.teamwork.telegram_bot_for_shelter.model.volunteer.Volunteer;

/**
 * репозиторий для хранения волонтёров
 */
@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
