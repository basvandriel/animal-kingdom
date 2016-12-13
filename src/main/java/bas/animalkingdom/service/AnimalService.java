package bas.animalkingdom.service;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.dao.AnimalDao;
import bas.animalkingdom.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Collection<Animal> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            return;
        }
        animalRepository.getAllAnimals().add(animal);
    }

}
