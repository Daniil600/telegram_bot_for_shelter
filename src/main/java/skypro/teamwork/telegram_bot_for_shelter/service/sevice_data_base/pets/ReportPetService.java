package skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.pets;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.ReportPet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.ReportPetRepository;

import java.util.Collection;

@Service
public class ReportPetService {
    private final ReportPetRepository reportPetRepository;

    public ReportPetService(ReportPetRepository reportPetRepository) {
        this.reportPetRepository = reportPetRepository;
    }

    public ReportPet addReportPet(ReportPet reportPet) {
        return reportPetRepository.save(reportPet);
    }

    public ReportPet findReportPet(long id) {
        return reportPetRepository.findById(id).orElse(null);
    }

    public ReportPet editReportPet(ReportPet reportPet) {
        return reportPetRepository.save(reportPet);
    }

    public void deletePet(long id) {
        reportPetRepository.deleteById(id);
    }

    public Collection<ReportPet> getAll() {
        return reportPetRepository.findAll();
    }
}
