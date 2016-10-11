package bas.animalkingdom.threads;

import bas.animalkingdom.zoo.Cage;

/**
 * A {@link ReptileEggHatcherThread}
 */
public class ReptileEggHatcherThread {

    /**
     * The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    private Cage reptileCage;

    /**
     * Creates a new {@link ReptileEggHatcherThread}
     *
     * @param reptileCage The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    public ReptileEggHatcherThread(Cage reptileCage) {
        this.reptileCage = reptileCage;
    }

    /**
     * Retrieves the reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     *
     * @return The reptile {@link Cage} for this {@link ReptileEggHatcherThread}.
     */
    public Cage getReptileCage() {
        return reptileCage;
    }
}
