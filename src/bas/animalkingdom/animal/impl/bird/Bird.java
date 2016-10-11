package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

/**
 * A {@link Bird} {@link Animal}.
 */
public abstract class Bird extends Animal implements IBird {

    /**
     * Creates a new {@link Bird} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Bird} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Bird} {@link Animal}.
     * @param name            The name of the {@link Bird} {@link Animal}.
     * @param color           The color of the {@link Bird} {@link Animal}.
     * @param weight          The weight of the {@link Bird} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Bird} {@link Animal}.
     */
    public Bird(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }
}
