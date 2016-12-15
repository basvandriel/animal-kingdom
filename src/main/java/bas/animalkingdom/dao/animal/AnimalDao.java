package bas.animalkingdom.dao.animal;

import bas.animalkingdom.animal.Animal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalDao {
    /**
     * @return All the animals with all properties
     */
    public abstract ArrayList<Animal> readAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    /**
     * @return The read animal with all it's properties
     */
    public abstract Animal read(String uuid);

    /**
     * @return Edits a animal
     */
    public abstract void update(Animal animals);

    /**
     * Adds a animal
     *
     * @return
     */
    public abstract Animal add();
}
