package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * A {@link Pinguin} {@link Bird} {@link Animal}.
 */
public class Pinguin extends Bird {
    /**
     * Creates a new {@link Pinguin} {@link Bird} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Pinguin} {@link Bird} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Pinguin} {@link Bird} {@link Animal}.
     * @param name            The name of the {@link Pinguin} {@link Bird} {@link Animal}.
     * @param color           The color of the {@link Pinguin} {@link Bird} {@link Animal}.
     * @param weight          The weight of the {@link Pinguin} {@link Bird} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Pinguin} {@link Bird} {@link Animal}.
     */
    public Pinguin(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link Pinguin} communicates
     *
     * @return The string how the {@link Pinguin} communicates
     */
    @Override
    public String communicate() {
        return "What does a pinguin even say?";
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
     * Resolves the flying of the {@link Pinguin}
     *
     * @return The flying of the {@link Pinguin}
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
