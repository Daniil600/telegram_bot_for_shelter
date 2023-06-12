package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.ReportCat;

public interface ReportCatRepository extends JpaRepository<ReportCat, Long> {
}
