package bas.animalkingdom.animal.impl.mammal.mouse;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.Animal;

/**
 * An {@link GrayMouse} {@link Mammal} {@link Animal}
 */
public class GrayMouse extends Mouse {

    /**
     * Creates a new {@link GrayMouse}.
     *
     * @param gender          The {@link Gender} of the {@link GrayMouse}.
     * @param bodyCovering    The body covering of the {@link Mouse}.
     * @param name            The name of the {@link GrayMouse}.
     * @param color           The color of the {@link GrayMouse}.
     * @param weight          The weight of the {@link GrayMouse}.
     * @param maxNumberOfEggs The max number of eggs of the {@link GrayMouse}.
     */
    public GrayMouse(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link GrayMouse} communicates
     *
     * @return The string how the {@link GrayMouse} communicates
     */
    @Override
    public String communicate() {
        return "*gray mouse sound*";
    }
}
