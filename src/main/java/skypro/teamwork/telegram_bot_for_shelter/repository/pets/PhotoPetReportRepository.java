package skypro.teamwork.telegram_bot_for_shelter.repository.pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.PhotoPetReport;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;
@Repository
public interface PhotoPetReportRepository extends JpaRepository<PhotoPetReport, Long> {
    ReportPet findPhotoPetReportById(long reportPetId);

}
