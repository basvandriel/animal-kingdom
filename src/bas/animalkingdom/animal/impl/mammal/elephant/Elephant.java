package bas.animalkingdom.animal.impl.mammal.elephant;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;

import java.util.ArrayList;

/**
 * An {@link Elephant} {@link Mammal} {@link Animal}
 */
public class Elephant extends Mammal {

    /**
     * The ear size of the {@link Elephant}
     */
    protected int earSize;

    /**
     * Creates a new {@link Elephant}.
     *
     * @param gender          The {@link Gender} of the {@link Elephant} {@link Mammal} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Elephant} {@link Mammal} {@link Animal}.
     * @param name            The name of the {@link Elephant} {@link Mammal} {@link Animal}.
     * @param color           The color of the {@link Elephant} {@link Mammal} {@link Animal}.
     * @param weight          The weight of the {@link Elephant} {@link Mammal} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Elephant} {@link Mammal} {@link Animal}.
     */
    public Elephant(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs, int earSize) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
        this.earSize = earSize;
    }

    /**
     * Suckles the the {@link Elephant} {@link Mammal} {@link Animal} babies
     *
     * @param babies The {@link Elephant} {@link Mammal} {@link Animal} babies
     */
    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }
    /**
     * Resolves the string how the {@link Elephant} communicates
     *
     * @return The string how the {@link Elephant} communicates
     */
    @Override
    public String communicate() {
        return null;
    }

    /**
     * Sets the ear size of the {@link Elephant}
     *
     * @param earSize The ear size of the {@link Elephant}
     */
    public void setEarSize(int earSize) {
        this.earSize = earSize;
    }

    /**
     * Retrieves the ear size of the {@link Elephant}
     *
     * @return The ear size of the {@link Elephant}
     */
    public int getEarSize() {
        return earSize;
    }
}
