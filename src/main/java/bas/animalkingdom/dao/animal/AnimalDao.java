package bas.animalkingdom.dao.animal;

import bas.animalkingdom.animal.Animal;
import com.mysql.jdbc.Connection;

import java.util.ArrayList;
import java.util.UUID;

public abstract class AnimalDao {

    private Connection connection;

    public AnimalDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return All the animals with all properties
     */
    public abstract ArrayList<Animal> readAll();

    /**
     * @return The read animal with all it's properties
     */
    public abstract Animal read(UUID uuid);

    /**
     * @return Edits a animal
     */
    public abstract Animal edit();

    /**
     * Adds a animal
     *
     * @return
     */
    public abstract Animal add();
}
