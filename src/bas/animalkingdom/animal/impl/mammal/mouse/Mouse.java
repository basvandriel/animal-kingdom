package bas.animalkingdom.animal.impl.mammal.mouse;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;

import java.util.ArrayList;

/**
 * An {@link Mouse} {@link Mammal} {@link Animal}
 */
public class Mouse extends Mammal {

    /**
     * Creates a new {@link Mouse}.
     *
     * @param gender          The {@link Gender} of the {@link Mouse}.
     * @param bodyCovering    The body covering of the {@link Mouse}.
     * @param name            The name of the {@link Mouse}.
     * @param color           The color of the {@link Mouse}.
     * @param weight          The weight of the {@link Mouse}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Mouse}.
     */
    public Mouse(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link Mouse} communicates
     *
     * @return The string how the {@link Mouse} communicates
     */
    @Override
    public String communicate() {
        return "*mouse sound*";
    }
}
