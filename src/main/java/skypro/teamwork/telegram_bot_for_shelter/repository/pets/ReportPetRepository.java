package skypro.teamwork.telegram_bot_for_shelter.repository.pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;

/**
 * класс для хранения ежедневных отчетов, присылаемых от усыновителей в испытательный период
 */
@Repository
public interface ReportPetRepository extends JpaRepository<ReportPet, Long> {
}