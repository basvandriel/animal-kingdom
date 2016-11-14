package bas.animalkingdom.animal.impl.mammal.mouse;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.Animal;

/**
 * An {@link WhiteMouse} {@link Mammal} {@link Animal}
 */
public class WhiteMouse extends Mouse {

    /**
     * Creates a new {@link WhiteMouse}.
     *
     * @param gender          The {@link Gender} of the {@link WhiteMouse}.
     * @param bodyCovering    The body covering of the {@link WhiteMouse}.
     * @param name            The name of the {@link WhiteMouse}.
     * @param color           The color of the {@link WhiteMouse}.
     * @param weight          The weight of the {@link WhiteMouse}.
     * @param maxNumberOfEggs The max number of eggs of the {@link WhiteMouse}.
     */
    public WhiteMouse(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link WhiteMouse} communicates
     *
     * @return The string how the {@link WhiteMouse} communicates
     */
    @Override
    public String communicate() {
        return "*white mouse sound*";
    }
}
