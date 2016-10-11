package bas.animalkingdom.threads;

import bas.animalkingdom.animal.gender.impl.Female;

/**
 * A {@link OvulatingThread}.
 */
public class OvulatingThread extends Thread {

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
