package bas.animalkingdom.service;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.dao.animal.AnimalDao;
import bas.animalkingdom.dao.animal.MySQLAnimalDAO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Service
public class AnimalService {


    public void readAnimals() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        animalDao.readAll();
    }

    public void addAnimal(Animal hatch) {
    }
}
