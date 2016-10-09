package bas.animalkingdom.animal.impl.special;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.bird.IBird;
import bas.animalkingdom.animal.impl.mammal.IMammal;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.impl.reptile.IReptile;

import java.util.ArrayList;

/**
 * Created by Bas on 20-9-2016.
 */
public class Platypus extends Animal implements IBird, IMammal, IReptile {
    /**
     * @param gender {@link Gender} adf
     */
    public Platypus(Gender gender) {
        super(gender);
    }

    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }

    @Override
    public String crawl() {
        return null;
    }

    @Override
    public ArrayList<Egg> layEggs() {
        return null;
    }

    @Override
    public String fly() {
        return null;
    }

    @Override
    public void hatchEggs(ArrayList<Egg> layedEggs) {

    }

    @Override
    public String communicate() {
        return null;
    }
}
