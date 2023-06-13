package skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.pets;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PetRepository;

import java.util.Collection;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findPet(long id) {
        return petRepository.findById(id).orElse(null);
    }

    public Pet editPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(long id) {
        petRepository.deleteById(id);
    }

    public Collection<Pet> getAll() {
        return petRepository.findAll();
    }
}
