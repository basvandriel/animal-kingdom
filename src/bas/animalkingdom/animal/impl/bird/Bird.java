package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;


public abstract class Bird extends Animal implements IBird {

    public Bird(Gender gender) {
        super(gender);
    }
}
