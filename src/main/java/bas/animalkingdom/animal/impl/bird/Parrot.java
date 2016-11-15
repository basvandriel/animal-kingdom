package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.gender.Gender;

/**
 * A {@link Parrot} {@link Bird} {@link bas.animalkingdom.animal.Animal}.
 */
public class Parrot extends Bird {


    /**
     * Creates a new {@link Parrot} {@link Bird} {@link bas.animalkingdom.animal.Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Parrot} {@link Bird}.
     * @param bodyCovering    The body covering of the {@link Parrot} {@link Bird}.
     * @param name            The name of the {@link Parrot} {@link Bird}.
     * @param color           The color of the {@link Parrot} {@link Bird} .
     * @param weight          The weight of the {@link Parrot} {@link Bird}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Parrot}.
     */
    public Parrot(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link Parrot} communicates
     *
     * @return The string how the {@link Parrot} communicates
     */
    @Override
    public String communicate() {
        return "Parrot sounddddd";
    }
}
