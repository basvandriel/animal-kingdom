package bas.animalkingdom.animal.impl.bird;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.IEggLayer;

import java.util.ArrayList;

/**
 * An {@link IBird} interface for an {@link Animal} who is a {@link Bird}.
 */
public interface IBird extends IEggLayer {

    /**
     * Resolves the flying of the {@link IBird}
     *
     * @return The flying of the {@link IBird}
     */
    public String fly();

    /**
     * Hatches the laid eggs
     *
     * @param layedEggs The laid eggs
     */
    public void hatchEggs(ArrayList<Egg> layedEggs);
}
