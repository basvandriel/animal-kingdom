package bas.animalkingdom.repository;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
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
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost/animal-kingdom", "root", "password");

        AnimalDao animalDao = new MySQLAnimalDAO(connection);
        return animalDao.readAll();
    }
}
