package bas.animalkingdom.animal;

import java.util.ArrayList;

/**
 * An {@link IEggLayer} interface for an {@link Animal} who lays eggs
 */
public interface IEggLayer {

    /**
     * Lay eggs
     *
     * @return eggs The eggs that has been laid.
     */
    public ArrayList<Egg> layEggs();
}
