package bas.animalkingdom.animal.impl.mammal;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;

public class Mammal extends Animal implements IMammal {

    public Mammal(Gender gender) {
        super(gender);
    }
}
