package skypro.teamwork.telegram_bot_for_shelter.service.sevice_data_base.pets;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.pet.Pet;
import skypro.teamwork.telegram_bot_for_shelter.repository.pets.PetRepository;

import java.util.Collection;

/**
 * сервис для реализации методов для pet
 */
@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * добавляет питомца в базу данных
     * @param pet питомец
     * @return добавленного питомца
     */
    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    /**
     * находит в базе данных питомца по идентификатору
     * @param id идентификатор питомца
     * @return возвращает найденного питомца
     */
    public Pet findPet(long id) {
        return petRepository.findById(id).orElse(null);
    }

    /**
     * находит питомца в базе данных по идентификатору и заменяет его на нового
     * @param pet все параметры питомца
     * @return возвращает нового введенного питомца
     */
    public Pet editPet(Pet pet) {
        return petRepository.save(pet);
    }

    /**
     * находит питомца в базе данных и удаляет его
     * @param id идентификатор питомца
     */
    public void deletePet(long id) {
        petRepository.deleteById(id);
    }

    /**
     * @return возвращает коллекцию всех питомцев из базы данных
     */
    public Collection<Pet> getAll() {
        return petRepository.findAll();
    }
}
