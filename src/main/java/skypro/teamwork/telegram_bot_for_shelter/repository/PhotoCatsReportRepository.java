package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.Cat;
import skypro.teamwork.telegram_bot_for_shelter.model.PhotoCats;
import skypro.teamwork.telegram_bot_for_shelter.model.PhotoCatsReport;
import skypro.teamwork.telegram_bot_for_shelter.model.ReportCat;

public interface PhotoCatsReportRepository extends JpaRepository<PhotoCatsReport, Long> {
    ReportCat findPhotoCatsReportById(long reportcatId);

}
