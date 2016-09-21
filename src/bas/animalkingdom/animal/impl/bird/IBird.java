package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.IEggLayer;

import java.util.ArrayList;

/**
 * Created by Bas on 20-9-2016.
 */
public interface IBird extends IEggLayer {

    /**
     *
     * @return fly
     */
    public String fly();

    /**
     *
     * @param layedEggs The layed eggs
     */
    public void hatchEggs(ArrayList<Egg> layedEggs);
}
