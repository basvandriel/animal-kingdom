package bas.animalkingdom.animal.impl.reptile;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * Created by Bas on 20-9-2016.
 */
public class Snake extends Reptile {
    public Snake(Gender gender) {
        super(gender);
    }

    @Override
    public String crawl() {
        return null;
    }

    @Override
    public ArrayList<Egg> layEggs() {
        return null;
    }
}
