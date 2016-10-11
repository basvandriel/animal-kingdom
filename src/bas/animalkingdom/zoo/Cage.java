package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import com.sun.scenario.animation.shared.AnimationAccessor;

import java.util.ArrayList;


/**
 *
 */
public class Cage {

    /**
     * The caged {@link Animal}s in this {@link Cage}.
     */
    private ArrayList<Animal> cagedAnimals;

    /**
     * Selects a {@link Animal} in this {@link Cage}.
     *
     * @return A {@link Animal} in this {@link Cage}.
     */
    public Animal selectAnimal() {
        return new Crocodile(new Male());
    }

    /**
     * The type of this {@link Cage}.
     */
    public void getCageType() {

    }

    /**
     * Adds a {@link Animal} in to {@link Cage}.
     *
     * @param anAnimal The {@link Animal} to add in this {@link Cage}.
     *
     * @return If the {@link Animal} in this {@link Cage} could be added.
     */
    public boolean addAnimal(Animal anAnimal) {
        return false;
    }

    /**
     * Retrieves the caged {@link Animal}s in this {@link Cage}.
     *
     * @return The caged {@link Animal}s in this {@link Cage}.
     */
    public ArrayList<Animal> getCagedAnimals() {
        return this.cagedAnimals;
    }

    /**
     * Adds {@link Animal} reptile eggs to this {@link Cage}.
     *
     * @param reptileEggs The {@link Animal} reptile eggs to this {@link Cage}.
     */
    public void addReptileEggs(ArrayList<Egg> reptileEggs) {

    }
}
