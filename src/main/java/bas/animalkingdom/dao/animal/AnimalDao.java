package bas.animalkingdom.dao.animal;

import bas.animalkingdom.animal.Animal;

import java.util.ArrayList;
import java.util.UUID;

interface AnimalDao {
    /**
     *
     * @return All the animals with all properties
     */
    public ArrayList<Animal> readAll();

    /**
     * @return The read animal with all it's properties
     */
    public Animal read(UUID uuid);

    /**
     *
     * @return Edits a animal
     */
    public Animal edit();

    /**
     * Adds a animal
     *
     * @return
     */
    public Animal add();
}
