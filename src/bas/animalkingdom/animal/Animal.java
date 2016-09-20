package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;

public class Animal {

    /**
     * The {@link bas.animalkingdom.animal.gender.Gender} of the {@link Animal}
     */
    private Gender gender;

    private String bodyCovering;

    private String name;

    private String color;

    private int weight;

    public Animal(Gender gender) {
        this.gender = gender;
    }
}
