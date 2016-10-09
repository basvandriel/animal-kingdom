package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

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
     * @param gender Gender
     */
    public Human(Gender gender) {
        super(gender);
    }

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

    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }
}
