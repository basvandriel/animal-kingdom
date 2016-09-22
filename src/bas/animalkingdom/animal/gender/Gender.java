package bas.animalkingdom.animal.gender;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;

import java.util.ArrayList;

public abstract class Gender {

    /**
     * The {@link Animal} belonging to this {@link Gender}
     */
    private Animal genderOwner;

    public boolean isPregnant() {
        return false;
    }

    public void propagate(Animal parent1, Animal parent2) {

    }

    public ArrayList<Egg> giveBirth() {
        ArrayList<Egg> eggs = new ArrayList<>();
        eggs.add(new Egg());
        return eggs;
    }

    public boolean isFemale() {
        return false;
    }

    public void setGenderOwner(Animal owner) {
        this.genderOwner = owner;
    }

}
