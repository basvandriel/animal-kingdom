package bas.animalkingdom.repository;

import bas.animalkingdom.animal.Animal;
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
        if(animal == null) {
            return;
        }
        animalRepository.getAllAnimals().add(animal);
    }

}
