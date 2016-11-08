package bas.animalkingdom.animal.gender;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * A {@link Gender}
 */
public abstract class Gender {

    /**
     * The {@link Animal} belonging to this {@link Gender}
     */
    private Animal genderOwner;

    /**
     * Creates a new {@link Gender}.
     */
    public Gender() {

    }

    /**
     * Checks if the {@link Animal} is pregnant or not.
     *
     * @return If the {@link Animal} is pregnant or not.
     */
    public abstract boolean isPregnant();

    /**
     * Propagates with 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} to propagate with.
     * @param parent2 The second {@link Animal} to propagate with.
     */
    public abstract void propagate(Animal parent1, Animal parent2) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException;

    /**
     * The birth of the {@link Gender}.
     *
     * @return The {@link Egg}s from the birth of the {@link Gender}.
     */
    public abstract ArrayList<Egg> giveBirth();

    /**
     * Checks if the {@link Gender} is a female.
     *
     * @return If the {@link Gender} is a female.
     */
    public abstract boolean isFemale();

    /**
     * Sets the {@link Animal} belonging to this {@link Gender}
     *
     * @param owner The {@link Animal} belonging to this {@link Gender}
     */
    public void setGenderOwner(Animal owner) {
        this.genderOwner = owner;
    }

    /**
     * Retrieves the {@link Animal} belonging to this {@link Gender}.
     *
     * @return The {@link Animal} belonging to this {@link Gender}.
     */
    public Animal getGenderOwner() {
        return genderOwner;
    }
}
