package bas.animalkingdom.animal;

/**
 * An {@link Egg}
 */
public class Egg {

    /**
     * The possible embryo (possible {@link Animal}) contained in this egg
     */
    private Animal embryo;

    /**
     * Checks if the {@link Egg} is inseminated or not
     *
     * @return If the {@link Egg} is inseminated or not
     */
    public boolean isInseminated() {
        return false;
    }

    /**
     * Inseminates this {@link Egg} by 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} parent.
     * @param parent2 The second {@link Animal} parent.
     */
    public void inseminate(Animal parent1, Animal parent2) {

    }

    /**
     * Retrieves the possible embryo (possible {@link Animal}) contained in this egg.
     *
     * @return The possible embryo (possible {@link Animal}) contained in this egg.
     */
    public Animal getEmbryo() {
        return this.embryo;
    }
}