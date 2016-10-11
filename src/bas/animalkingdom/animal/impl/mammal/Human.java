package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * A {@link Human} {@link Mammal} {@link Animal}
 */
class Human extends Mammal {

    /**
     * A identiefier if the {@link Human} uses birth control
     */
    private boolean usesBirthControl;

    /**
     * The last name of the {@link Human}
     */
    public String lastName;

    /**
     * The middle name of the {@link Human}
     */
    public String insertion;

    /**
     * The partner (married) of this {@link Human}
     */
    private Human partner;

    /**
     * Creates a new {@link Human} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Human} {@link Mammal} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Human} {@link Mammal} {@link Animal}.
     * @param name            The name of the {@link Human} {@link Mammal} {@link Animal}.
     * @param color           The color of the {@link Human} {@link Mammal} {@link Animal}.
     * @param weight          The weight of the {@link Human} {@link Mammal} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Human} {@link Mammal} {@link Animal}.
     */
    public Human(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Resolves the string how the {@link Human} communicates
     *
     * @return The string how the {@link Human} communicates
     */
    @Override
    public String communicate() {
        return null;
    }


    /**
     *
     */
    public void makeLove() {

    }

    /**
     *
     */
    public void makeLove(Human partner) {
    }

    /**
     *
     */
    private void marriageLove() {

    }

    /**
     *
     */
    private void adulteryLove(Human lover) {

    }

    /**
     *
     */
    public boolean mary(Human partner) {
        return false;
    }

    /**
     *
     */
    public boolean isMarried() {
        return false;
    }

    /**
     *
     */
    public void divorce() {

    }

    /**
     * Suckles the the {@link Human} {@link Mammal} {@link Animal} babies
     *
     * @param babies The {@link Human} {@link Mammal} {@link Animal} babies
     */
    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }
}
