package bas.animalkingdom.service;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.dao.animal.AnimalDao;
import bas.animalkingdom.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;


@Service
public class AnimalService {

    @Autowired
    private AnimalDao animalDao;

    public void readAnimals() throws SQLException {
        this.animalDao.readAll();
    }

}
