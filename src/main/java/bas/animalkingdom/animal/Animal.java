package bas.animalkingdom.animal;


import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.zoo.Zoo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Animal {

    /**
     *
     */
    private UUID uuid;
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
     * @param gender          The {@link Gender} of the {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Animal}.
     * @param name            The name of the {@link Animal}.
     * @param color           The color of the {@link Animal}.
     * @param weight          The weight of the {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Animal}.
     */
    public Animal(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        this.uuid = UUID.randomUUID();

        this.gender = gender;
        this.bodyCovering = bodyCovering;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxNumberOfEggs = maxNumberOfEggs;

        this.gender.setGenderOwner(this);

        Zoo.getInstance("ICO41A").addAnimal(this);
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
    public void propagate(Animal partner) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (!this.getClass().equals(partner.getClass())) {
            return;
        }
        this.getGender().propagate(this, partner);
        partner.getGender().propagate(partner, this);
    }

    /**
     * Checks if the {@link Animal} is pregnant or not.
     *
     * @return If the {@link Animal} is pregnant or not.
     */
    public boolean isPregnant() {
        return this.getGender().isPregnant();
    }

    /**
     * The birth of the {@link Animal}.
     *
     * @return The {@link Egg}s from the birth of the {@link Animal}.
     */
    public ArrayList<Egg> giveBirth() {
        return this.getGender().giveBirth();
    }

    /**
     * Checks if the {@link Animal} is a female or not.
     *
     * @return If the {@link Animal} is a female or not.
     */
    public boolean isFemale() {
        return this.getGender().isFemale();
    }

    /**
     * Sets the unique UUID of the {@link Animal}
     *
     * @param uuid The unique UUID of the {@link Animal}
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
     * Retrieves the unique UUID of the {@link Animal}
     *
     * @return The unique UUID of the {@link Animal}
     */
    public UUID getUuid() {
        return this.uuid;
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
     *
     * @return The max number of eggs of the {@link Animal}.
     */
    public int getMaxNumberOfEggs() {
        return maxNumberOfEggs;
    }
}
