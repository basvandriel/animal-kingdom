package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * A {@link Parrot} {@link Bird} {@link Animal}.
 */
public class Parrot extends Bird {


    /**
     * Creates a new {@link Parrot} {@link Bird} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Parrot} {@link Bird} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Parrot} {@link Bird} {@link Animal}.
     * @param name            The name of the {@link Parrot} {@link Bird} {@link Animal}.
     * @param color           The color of the {@link Parrot} {@link Bird} {@link Animal}.
     * @param weight          The weight of the {@link Parrot} {@link Bird} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Parrot} {@link Bird} {@link Animal}.
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

    /**
     * Lay eggs
     *
     * @return eggs The eggs that has been laid.
     */
    @Override
    public ArrayList<Egg> layEggs() {
        return null;
    }

    /**
     * Resolves the flying of the {@link Parrot}
     *
     * @return The flying of the {@link Parrot}
     */
    @Override
    public String fly() {
        return null;
    }

    /**
     * Hatches the laid eggs
     *
     * @param layedEggs The laid eggs
     */
    @Override
    public void hatchEggs(ArrayList<Egg> layedEggs) {

    }
}
