package bas.animalkingdom.threads;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.zoo.Cage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * A {@link ReptileEggHatcherThread}
 */
public class ReptileEggHatcherThread extends Thread {

    /**
     * The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    private Cage reptileCage;

    /**
     * The reptile {@link Egg}'s for this {@link ReptileEggHatcherThread}.
     */
    private ArrayList<Egg> reptileEggs;

    /**
     * Creates a new {@link ReptileEggHatcherThread}
     *
     * @param reptileCage The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    public ReptileEggHatcherThread(Cage reptileCage, ArrayList<Egg> reptileEggs) {
        this.reptileCage = reptileCage;
        this.reptileEggs = reptileEggs;
    }

    @Override
    public void run() {
        super.run();
        if (this.reptileCage == null) {
            return;
        }
        try {
            this.reptileCage.addReptileEggs(this.reptileEggs);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     *
     * @return The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    public Cage getReptileCage() {
        return reptileCage;
    }

    /**
     * Retrieves the reptile {@link Egg}'s for this {@link ReptileEggHatcherThread}.
     *
     * @return The reptile {@link Egg}'s for this {@link ReptileEggHatcherThread}.
     */
    public ArrayList<Egg> getReptileEggs() {
        return reptileEggs;
    }
}
