package skypro.teamwork.telegram_bot_for_shelter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.AppDocument;

public interface AppDocumentRepository extends JpaRepository<AppDocument, Long> {
}
