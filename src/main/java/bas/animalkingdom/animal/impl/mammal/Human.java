package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * The extra chance of getting an STD
     */
    private double extraStdChance;

    /**
     * The extra chance of this human getting caught cheating
     */
    private double extraCaughtCheatingChance;


    /**
     * The {@link STD}s for this {@link Human}
     */
    private ArrayList<STD> stds;

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
        this.stds = new ArrayList<>();
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
    public void makeLove() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (partner == null) {
            return;
        }
        this.makeLove(this.partner);
    }

    /**
     * Makes love to another {@link Human} partner
     *
     * @param partner The {@link Human} partner to make love to
     */
    public void makeLove(Human partner) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (!partner.getClass().isAssignableFrom(this.getClass())) {
            return;
        }

        //haha
        if (partner == this) {
            return;
        }

        //ayy
        if (partner == this.partner) {
            this.marriageLove();
        }

        //Single love or cheating
        if (partner != this.partner) {
            if (this.isMarried() || partner.isMarried() && partner != (this).partner) {
                this.adulteryLove(partner);
            }

            double currentStdChance = (Math.random() + this.extraStdChance);

            if (Math.random() < currentStdChance) {
                STD std = new STD("Some random STD named with " + currentStdChance);
                Stream.of(this, partner).filter(Human::isUsingBirthControl).
                        collect(Collectors.toList()).
                        forEach(human -> human.getSTDs().add(std));
            }
            this.extraStdChance += 0.05;

            double currentCaughtCheatingChance = 0.5 + this.extraCaughtCheatingChance;
            if (isMarried() && (Math.random() < currentCaughtCheatingChance)) {
                this.divorce();
            } else {
                this.extraCaughtCheatingChance += 0.05;
            }
        }

        if (!this.usesBirthControl && !partner.isUsingBirthControl()) {
            this.propagate(partner);
            partner.propagate(this);
        }
    }

    /**
     * Married love
     */

    private void marriageLove() {
        System.out.println("marriage love");
    }

    /**
     * Makes adultery love to another {@link Human} partner (lover)
     *
     * @param lover The {@link Human} partner (lover) to make love to
     */
    private void adulteryLove(Human lover) {
        System.out.println("marriage love with " + lover.getName());
    }

    /**
     * Marries to another {@link Human}
     *
     * @param partner The {@link Human} to marry to
     */
    public boolean mary(Human partner) {
        if (partner == null || partner == this ||
                this.isMarried() || partner.isMarried()) {
            return false;
        }

        setPartner(partner);
        partner.setPartner(this);
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
        if (!this.isMarried()) {
            return;
        }
        this.partner.setPartner(null);
        this.setPartner(null);
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
    public boolean isUsingBirthControl() {
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

    /**
     * Retrieves the {@link STD}s for this {@link Human}
     *
     * @return The {@link STD}s for this {@link Human}
     */
    public ArrayList<STD> getSTDs() {
        return stds;
    }
}