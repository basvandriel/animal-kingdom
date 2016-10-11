package bas.animalkingdom.animal.gender.impl;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * A {@link Male} {@link Gender}
 */
public class Male extends Gender {

    /**
     * Checks if the {@link Male} {@link Gender} is pregnant or not.
     *
     * @return If the {@link Male} {@link Gender} is pregnant or not.
     */
    @Override
    public boolean isPregnant() {
        return false;
    }

    /**
     * Propagates with 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} to propagate with.
     * @param parent2 The second {@link Animal} to propagate with.
     */
    @Override
    public void propagate(Animal parent1, Animal parent2) {

    }

    /**
     * The birth of the {@link Male} {@link Gender}.
     *
     * @return The {@link Egg}s from the birth of the {@link Male} {@link Gender}.
     */
    @Override
    public ArrayList<Egg> giveBirth() {
        return null;
    }

    /**
     * Checks if the {@link Male} {@link Gender} is a female.
     *
     * @return If the {@link Male} {@link Gender} is a female.
     */
    @Override
    public boolean isFemale() {
        return false;
    }
}
