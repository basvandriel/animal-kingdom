package bas.animalkingdom.threads;

import bas.animalkingdom.animal.impl.mammal.Mammal;

/**
 * A {@link SuckleDispatcherThread}.
 */
public class SuckleDispatcherThread {

    /**
     * The {@link Mammal} mother for the {@link SuckleDispatcherThread}.
     */
    private Mammal mother;

    /**
     * Creates a new {@link SuckleDispatcherThread}
     *
     * @param mother The {@link Mammal} mother for the {@link SuckleDispatcherThread}.
     */
    public SuckleDispatcherThread(Mammal mother) {
        this.mother = mother;
    }

    /**
     * Retrieves the {@link Mammal} mother for the {@link SuckleDispatcherThread}.
     *
     * @return The {@link Mammal} mother for the {@link SuckleDispatcherThread}.
     */
    public Mammal getMother() {
        return mother;
    }
}
