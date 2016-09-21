package bas.animalkingdom.animal.impl.mammal;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Male;

import java.util.ArrayList;

public abstract class Mammal extends Animal implements IMammal {

    public Mammal(Gender gender) {
        super(gender);
    }

    public void giveLifeBirth() {

    }

    public ArrayList<IMammal> getBabies() {
        ArrayList<IMammal> babies = new ArrayList<>();
        babies.add(new Human(new Male()));
        return babies;
    }
}
