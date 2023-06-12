package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.PhotoCatsReport;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.ReportCat;

public interface PhotoCatsReportRepository extends JpaRepository<PhotoCatsReport, Long> {
    ReportCat findPhotoCatsReportById(long reportcatId);

}
