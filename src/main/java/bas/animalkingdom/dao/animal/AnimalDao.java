package bas.animalkingdom.dao.animal;

import bas.animalkingdom.animal.Animal;
import com.mysql.jdbc.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public interface AnimalDao {
    /**
     * @return All the animals with all properties
     */
    public abstract ArrayList<Animal> readAll() throws SQLException;

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
