package bas.animalkingdom.animal.impl.reptile;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

/**
 * A {@link Crocodile} {@link Reptile} {@link Animal}
 */
public class Crocodile extends Reptile {

    /**
     * Creates a new {@link Crocodile} {@link Reptile} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Crocodile} {@link Reptile} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Crocodile} {@link Reptile} {@link Animal}.
     * @param name            The name of the {@link Crocodile} {@link Reptile} {@link Animal}.
     * @param color           The color of the {@link Crocodile} {@link Reptile} {@link Animal}.
     * @param weight          The weight of the {@link Crocodile} {@link Reptile} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Crocodile} {@link Reptile} {@link Animal}.
     */
    public Crocodile(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link Crocodile} communicates
     *
     * @return The string how the {@link Crocodile} communicates
     */
    @Override
    public String communicate() {
        return "GRRRRR CROCODILEELEELE";
    }
}
