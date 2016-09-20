package bas.animalkingdom.animal.impl.mammal.human;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;

import java.io.StringReader;

class Human extends Mammal {

    /**
     * A identiefier if the {@link Human} uses birth control
     */
    private boolean usesBirthControl;

    /**
     * The last name of the {@link Human}
     */
    private String lastName;

    /**
     * The partner (married) of this {@link Human}
     */
    private Human partner;

    /**
     * TODO: What should this variable be?
     */
    private String insertion;

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
