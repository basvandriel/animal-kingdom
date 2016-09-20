package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.gender.Gender;

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
     * TODO: What should this variable be?
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

    /**
     *
     * @param human
     *
     * @return boolean
     */
    public boolean isMarriedToHuman(Human human) {
        return this.getPartner() == human.getPartner();
    }

    public Human getPartner() {
        return this.partner;
    }
}
