package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import com.sun.scenario.animation.shared.AnimationAccessor;

import java.util.ArrayList;

/**
 * Created by Bas on 20-9-2016.
 */
public class Cage {

    private Animal[] cagedAnimals;

    public Animal selectAnimal() {
        return new Crocodile(new Male());
    }

    public void getCageType() {
    }

    public boolean addAnimal(Animal anAnimal) {
        return false;
    }

    public ArrayList<Animal> getCagedAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    public void addReptileEggs(ArrayList<Egg> reptileEggs) {

    }


}
