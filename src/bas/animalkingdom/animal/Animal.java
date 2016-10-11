package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;
import com.sun.scenario.animation.shared.AnimationAccessor;

import java.util.ArrayList;

public abstract class Animal {

    /**
     * The {@link Gender} of the {@link Animal}.
     */
    protected Gender gender;

    /**
     * The body covering of the {@link Animal}.
     */
    protected String bodyCovering;

    /**
     * The name of the {@link Animal}.
     */
    protected String name;

    /**
     * The color of the {@link Animal}.
     */
    protected String color;

    /**
     * The weight of the {@link Animal}.
     */
    protected int weight;

    /**
     * The max number of eggs of the {@link Animal}.
     */
    protected int maxNumberOfEggs;


    /**
     * Creates a new {@link Animal}.
     *
     * @param gender The {@link Gender} of the {@link Animal}.
     * @param bodyCovering The body covering of the {@link Animal}.
     * @param name The name of the {@link Animal}.
     * @param color The color of the {@link Animal}.
     * @param weight The weight of the {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Animal}.
     */
    public Animal(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        this.gender = gender;
        this.bodyCovering = bodyCovering;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxNumberOfEggs = maxNumberOfEggs;
    }

    /**
     * Resolves the string how the {@link Animal} communicates
     *
     * @return The string how the {@link Animal} communicates
     */
    public abstract String communicate();

    /**
     * Propagates with another {@link Animal}.
     *
     * @param partner The other {@link Animal} to propagate with.
     */
    public void propagate(Animal partner) {

    }

    /**
     * Checks if the {@link Animal} is pregnant or not.
     *
     * @return If the {@link Animal} is pregnant or not.
     */
    public boolean isPregnant() {
        return false;
    }

    /**
     * The birth of the {@link Animal}.
     *
     * @return The {@link Egg}s from the birth of the {@link Animal}.
     */
    public ArrayList<Egg> giveBirth() {


        ArrayList<Egg> eggs = new ArrayList<>();
        eggs.add(new Egg());
        return eggs;
    }

    /**
     * Checks if the {@link Animal} is a female or not.
     *
     * @return If the {@link Animal} is a female or not.
     */
    public boolean isFemale() {
        return false;
    }

    /**
     * Sets the {@link Gender} of the {@link Animal}.
     *
     * @param gender The {@link Gender} of the {@link Animal}.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Sets the body covering of the {@link Animal}.
     *
     * @param bodyCovering The body covering of the {@link Animal}.
     */
    public void setBodyCovering(String bodyCovering) {
        this.bodyCovering = bodyCovering;
    }

    /**
     * Sets the name of the {@link Animal}.
     *
     * @param name the name of the {@link Animal}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the color of the {@link Animal}.
     *
     * @param color The color of the {@link Animal}.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the weight of the {@link Animal}.
     *
     * @param weight The weight of the {@link Animal}.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Sets the max number of eggs of the {@link Animal}.
     *
     * @param maxNumberOfEggs The max number of eggs of the {@link Animal}.
     */
    public void setMaxNumberOfEggs(int maxNumberOfEggs) {
        this.maxNumberOfEggs = maxNumberOfEggs;
    }

    /**
     * Retrieves the {@link Gender} of the {@link Animal}.
     *
     * @return The {@link Gender} of the {@link Animal}.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Retrieves the body covering of the {@link Animal}.
     *
     * @return The body covering of the {@link Animal}.
     */
    public String getBodyCovering() {
        return bodyCovering;
    }

    /**
     * Retrieves the name of the {@link Animal}.
     *
     * @return The name of the {@link Animal}.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the color of the {@link Animal}.
     *
     * @return The color of the {@link Animal}.
     */
    public String getColor() {
        return color;
    }

    /**
     * Retrieves the weight of the {@link Animal}.
     *
     * @return The weight of the {@link Animal}.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Retrieves The max number of eggs of the {@link Animal}.
     * @return The max number of eggs of the {@link Animal}.
     */
    public int getMaxNumberOfEggs() {
        return maxNumberOfEggs;
    }
}
