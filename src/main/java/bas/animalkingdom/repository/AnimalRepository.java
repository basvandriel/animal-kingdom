package bas.animalkingdom.repository;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.dao.animal.AnimalDao;
import bas.animalkingdom.dao.animal.MySQLAnimalDAO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class AnimalRepository {

    private ArrayList<Animal> animals;

    public Collection<Animal> getAllAnimals() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //Get the driver
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "password");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        return animalDao.readAll();
    }

    public void updateAnimal(Animal animal) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (animal == null) {
            return;
        }
        //Get the driver
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "password");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        animalDao.update(animal);
    }

    public void addAnimal(Animal animal) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (animal == null) {
            return;
        }
        //Get the driver
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "password");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        animalDao.add(animal);
    }

    public void deleteAnimal(Animal animal) throws ClassNotFoundException, SQLException {
        if (animal == null) {
            return;
        }
        //Get the driver
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "password");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        animalDao.delete(animal);
    }
}
