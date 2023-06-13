package skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.user;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;
import skypro.teamwork.telegram_bot_for_shelter.model.user.User;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PetRepository;
import skypro.teamwork.telegram_bot_for_shelter.repository.user.UserRepository;

import java.util.Collection;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addPet(User user) {
        return userRepository.save(user);
    }

    public User findPet(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User editPet(User user) {
        return userRepository.save(user);
    }

    public void deletePet(long id) {
        userRepository.deleteById(id);
    }

    public Collection<User> getAll() {
        return userRepository.findAll();
    }


}
