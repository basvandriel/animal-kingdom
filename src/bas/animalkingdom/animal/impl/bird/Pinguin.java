package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * Created by Bas on 20-9-2016.
 */
public class Pinguin extends Bird {
    public Pinguin(Gender gender) {
        super(gender);
    }

    @Override
    public String communicate() {
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
}
