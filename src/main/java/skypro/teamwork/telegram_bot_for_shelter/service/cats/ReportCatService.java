package skypro.teamwork.telegram_bot_for_shelter.service.cats;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.ReportCat;
import skypro.teamwork.telegram_bot_for_shelter.repository.ReportCatRepository;

import java.util.Collection;

@Service
public class ReportCatService {
    private final ReportCatRepository reportCatRepository;

    public ReportCatService(ReportCatRepository reportCatRepository) {
        this.reportCatRepository = reportCatRepository;
    }

    public ReportCat addReportCat(ReportCat reportCat) {
        return reportCatRepository.save(reportCat);
    }

    public ReportCat findReportCat(long id) {
        return reportCatRepository.findById(id).orElse(null);
    }

    public ReportCat editReportCat(ReportCat reportCat) {
        return reportCatRepository.save(reportCat);
    }

    public void deleteCat(long id) {
        reportCatRepository.deleteById(id);
    }

    public Collection<ReportCat> getAll() {
        return reportCatRepository.findAll();
    }
}
