package bas.animalkingdom.service;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.dao.animal.AnimalDao;
import bas.animalkingdom.dao.animal.MySQLAnimalDAO;
import bas.animalkingdom.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    public void readAnimals() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    }

    public void addAnimal(Animal hatch) {
    }
}
