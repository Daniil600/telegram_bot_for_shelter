package skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.volunteer;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.volunteer.Volunteer;
import skypro.teamwork.telegram_bot_for_shelter.repository.volunteer.VolunteerRepository;

import java.util.Collection;

@Service
public class VolunteerService {
    VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public Volunteer addVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public Volunteer findVolunteer(long id) {
        return volunteerRepository.findById(id).orElse(null);
    }

    public Volunteer editVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public void deleteVolunteer(long id) {
        volunteerRepository.deleteById(id);
    }

    public Collection<Volunteer> getAll() {
        return volunteerRepository.findAll();
    }
}

