package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Female;
import javafx.scene.media.Media;

import java.util.ArrayList;

/**
 * A {@link Human} {@link Mammal} {@link Animal}
 */
public class Human extends Mammal {

    /**
     * If the {@link Human} uses birth control
     */
    private boolean usesBirthControl;

    /**
     * The last name of the {@link Human}
     */
    private String lastName;

    /**
     * The middle name of the {@link Human}
     */
    private String insertion;

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
        return "Hey im a human";
    }


    /**
     * Makes love
     */
    public void makeLove() {

    }

    /**
     * Makes love to another {@link Human} partner
     *
     * @param partner The {@link Human} partner to make love to
     */
    public void makeLove(Human partner) {
    }

    /**
     * Married love
     */
    private void marriageLove() {

    }

    /**
     * Makes adultery love to another {@link Human} partner (lover)
     *
     * @param lover The {@link Human} partner (lover) to make love to
     */
    private void adulteryLove(Human lover) {

    }

    /**
     * Marries to another {@link Human}
     *
     * @param partner The {@link Human} to marry to
     */
    public boolean mary(Human partner) {
        if (partner == null) {
            return false;
        }
        boolean currentHumanIsMarried = this.isMarried();
        boolean partnerIsMarried = partner.isMarried();

        if (currentHumanIsMarried || partnerIsMarried) {
            return false;
        }

        this.partner = partner;
        partner.partner = this;
        return true;
    }

    /**
     * Checks if the {@link Human} is married
     *
     * @return if the {@link Human} is married
     */
    public boolean isMarried() {
        return !(this.partner == null);
    }

    /**
     * Divorces the marriage
     */
    public void divorce() {
        if(!this.isMarried()) {
            return;
        }
        this.partner.partner = null;
        this.partner = null;
    }

    /**
     * Suckles the the {@link Human} {@link Mammal} {@link Animal} babies
     *
     * @param babies The {@link Human} {@link Mammal} {@link Animal} babies
     */
    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }

    /**
     * Sets if the {@link Human} uses birth control
     *
     * @param usesBirthControl If the {@link Human} uses birth control
     */
    public void setUsesBirthControl(boolean usesBirthControl) {
        this.usesBirthControl = usesBirthControl;
    }

    /**
     * Sets the last name of the {@link Human}
     *
     * @param lastName The last name of the {@link Human}
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the middle name of the {@link Human}
     *
     * @param insertion The middle name of the {@link Human}
     */
    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    /**
     * Sets the partner (married) of this {@link Human}
     *
     * @param partner The partner (married) of this {@link Human}
     */
    public void setPartner(Human partner) {
        this.partner = partner;
    }

    /**
     * Retrieves if the {@link Human} uses birth control
     *
     * @return if the {@link Human} uses birth control
     */
    public boolean isUsesBirthControl() {
        return usesBirthControl;
    }

    /**
     * Retrieves the last name of the {@link Human}
     *
     * @return The last name of the {@link Human}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the middle name of the {@link Human}
     *
     * @return The middle name of the {@link Human}
     */
    public String getInsertion() {
        return insertion;
    }

    /**
     * Retrieves the partner (married) of this {@link Human}
     *
     * @return The partner (married) of this {@link Human}
     */
    public Human getPartner() {
        return partner;
    }
}
