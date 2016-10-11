package bas.animalkingdom.animal.impl.reptile;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

/**
 * A {@link Reptile} {@link Animal}
 */
public abstract class Reptile extends Animal implements IReptile {

    /**
     * Creates a new {@link Reptile} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Reptile} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Reptile} {@link Animal}.
     * @param name            The name of the {@link Reptile} {@link Animal}.
     * @param color           The color of the {@link Reptile} {@link Animal}.
     * @param weight          The weight of the {@link Reptile} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Reptile} {@link Animal}.
     */
    public Reptile(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }
}
