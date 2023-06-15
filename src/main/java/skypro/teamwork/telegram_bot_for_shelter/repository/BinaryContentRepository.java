package skypro.teamwork.telegram_bot_for_shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.teamwork.telegram_bot_for_shelter.model.BinaryContent;

public interface BinaryContentRepository extends JpaRepository<BinaryContent, Long> {
}
