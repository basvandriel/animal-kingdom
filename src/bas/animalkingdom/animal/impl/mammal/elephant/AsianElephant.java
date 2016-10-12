package bas.animalkingdom.animal.impl.mammal.elephant;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.gender.Gender;

/**
 * An {@link AsianElephant} {@link Mammal} {@link Animal}
 */
public class AsianElephant extends Elephant {


    /**
     * Creates a new {@link AsianElephant}.
     *
     * @param gender          The {@link Gender} of the {@link AsianElephant}.
     * @param bodyCovering    The body covering of the {@link AsianElephant}.
     * @param name            The name of the {@link AsianElephant}.
     * @param color           The color of the {@link AsianElephant}.
     * @param weight          The weight of the {@link AsianElephant}.
     * @param maxNumberOfEggs The max number of eggs of the {@link AsianElephant}.
     */
    public AsianElephant(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs, int earSize) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs, earSize);
    }

    /**
     * Resolves the string how the {@link AsianElephant} communicates
     *
     * @return The string how the {@link AsianElephant} communicates
     */
    @Override
    public String communicate() {
        return "*asian loud air-horn sound*";
    }
}
