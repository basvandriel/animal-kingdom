package bas.animalkingdom.animal.impl.mammal.elephant;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Mammal;

import java.util.ArrayList;

public class Elephant extends Mammal {

    /**
     * The ear size of the {@link Elephant}
     */
    protected int earSize;

    public Elephant(Gender gender, int earSize) {
        super(gender);
        this.earSize = earSize;
    }

    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }
}
