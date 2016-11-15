package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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

    /**
     * Resolves the flying sound of the {@link Bird}
     *
     * @return The flying sound of the {@link Bird}
     */
    public String fly() {
        return "Flying like a " + getClass().getSimpleName();
    }

    /**
     * Lay eggs
     *
     * @return eggs The eggs that has been laid.
     */
    @Override
    public ArrayList<Egg> layEggs() {
        return this.giveBirth();
    }

    /**
     * Hatches the laid eggs
     *
     * @param layedEggs The laid eggs
     */
    @Override
    public void hatchEggs(ArrayList<Egg> layedEggs) {
        if (layedEggs == null) {
            return;
        }
        layedEggs.forEach(egg -> {
            try {
                egg.hatch();
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}
