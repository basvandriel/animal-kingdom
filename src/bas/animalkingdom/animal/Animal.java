package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;
import com.sun.scenario.animation.shared.AnimationAccessor;

import java.util.ArrayList;

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
     */
    protected int maxNumberOfEggs;

    /**
     * @param gender {@link Gender} adf
     */
    public Animal(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public abstract String communicate();

    public void propagate(Animal partner) {

    }

    public boolean isPregnant() {
        return false;
    }

    public ArrayList<Egg> giveBirth() {


        ArrayList<Egg> eggs = new ArrayList<>();
        eggs.add(new Egg());
        return eggs;
    }

    public boolean isFemale() {
        return false;
    }

}
