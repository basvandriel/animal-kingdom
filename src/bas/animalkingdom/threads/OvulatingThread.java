package bas.animalkingdom.threads;

import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;

import java.lang.reflect.InvocationTargetException;

/**
 * A {@link OvulatingThread}.
 */
public class OvulatingThread extends Thread {

    /**
     * The menstruation of 2 seconds in milliseconds
     */
    private final int MENSTRUATION_CYCLE = 2000;

    /**
     * The initial delay for the {@link OvulatingThread}.
     */
    private int initialDelay;

    /**
     * The {@link Female} for the {@link OvulatingThread}.
     */
    private Female female;


    /**
     * Creates a new {@link OvulatingThread}.
     *
     * @param initialDelay The initial delay for the {@link OvulatingThread}.
     * @param female       The {@link Female} for the {@link OvulatingThread}.
     */
    public OvulatingThread(int initialDelay, Female female) {
        this.initialDelay = initialDelay;
        this.female = female;
    }


    @Override
    public void run() {
        super.run();
        try {
            sleep(this.initialDelay);
            while (true) {
                sleep(this.MENSTRUATION_CYCLE);
                this.female.ovulate();


                try {
                    this.female.getGenderOwner().propagate(new Human(new Male(), "BodyCovering1", "Elephantor the Normal Elephant", "Gray red", 1200, 0));

                    //((Elephant) this.female.getGenderOwner()).giveLifeBirth();

                } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                sleep(this.MENSTRUATION_CYCLE);
                this.female.menstruate();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the initial delay for the {@link OvulatingThread}.
     *
     * @return the initial delay for the {@link OvulatingThread}.
     */
    public int getInitialDelay() {
        return initialDelay;
    }

    /**
     * Retrieves the {@link Female} for the {@link OvulatingThread}.
     *
     * @return The {@link Female} for the {@link OvulatingThread}.
     */
    public Female getFemale() {
        return female;
    }
}
