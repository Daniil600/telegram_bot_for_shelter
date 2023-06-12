package skypro.teamwork.telegram_bot_for_shelter.service.cats;

import org.springframework.stereotype.Service;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.Cat;
import skypro.teamwork.telegram_bot_for_shelter.repository.CatRepository;

import java.util.Collection;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat findCat(long id) {
        return catRepository.findById(id).orElse(null);
    }

    public Cat editCat(Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(long id) {
        catRepository.deleteById(id);
    }

    public Collection<Cat> getAll() {
        return catRepository.findAll();
    }
}
