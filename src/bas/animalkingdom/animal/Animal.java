package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;

public abstract class Animal {

    /**
     * The {@link bas.animalkingdom.animal.gender.Gender} of the {@link Animal}
     */
    protected Gender gender;

    /**
     *
     */
    protected String bodyCovering;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String color;

    /**
     *
     */
    protected int weight;

    /**
     *
     * @param gender {@link Gender} adf
     */
    public Animal(Gender gender) {
        this.gender = gender;
    }
}
