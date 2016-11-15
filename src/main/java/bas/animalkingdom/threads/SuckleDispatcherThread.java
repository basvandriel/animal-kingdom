package bas.animalkingdom.threads;


import bas.animalkingdom.animal.impl.mammal.IMammal;
import bas.animalkingdom.animal.impl.mammal.Mammal;

import java.util.ArrayList;

/**
 * A {@link SuckleDispatcherThread}.
 */
public class SuckleDispatcherThread extends Thread {

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

    @Override
    public void run() {
        super.run();

        ArrayList<IMammal> babies = this.mother.getBabies();
        for (IMammal baby : babies) {
            //Babies are already added to the zoo
        }
        babies.clear();
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
