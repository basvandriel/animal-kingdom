package bas.animalkingdom.animal.impl.mammal.elephant;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.Animal;

/**
 * An {@link AfricanElephant} {@link Mammal} {@link Animal}
 */
public class AfricanElephant extends Elephant {

    /**
     * Creates a new {@link AfricanElephant}.
     *
     * @param gender          The {@link Gender} of the {@link AfricanElephant}.
     * @param bodyCovering    The body covering of the {@link AfricanElephant}.
     * @param name            The name of the {@link AfricanElephant}.
     * @param color           The color of the {@link AfricanElephant}.
     * @param weight          The weight of the {@link AfricanElephant}.
     * @param maxNumberOfEggs The max number of eggs of the {@link AfricanElephant}.
     */
    public AfricanElephant(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link AfricanElephant} communicates
     *
     * @return The string how the {@link AfricanElephant} communicates
     */
    @Override
    public String communicate() {
        return "*african loud air-horn sound*";
    }
}


