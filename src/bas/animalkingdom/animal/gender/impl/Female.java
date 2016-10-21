package bas.animalkingdom.animal.gender.impl;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.util.ArrayList;

/**
 * A {@link Female} {@link Gender}
 */
public class Female extends Gender {

    /**
     * The produced {@link Egg}s of the {@link Female} {@link Gender}.
     */
    private ArrayList<Egg> eggs;
    
    /**
     * @return Produces {@link Egg}s
     */
    public ArrayList<Egg> produceEggs() {
        ArrayList<Egg> eggs = new ArrayList<>();
        eggs.add(new Egg());
        return eggs;
    }

    /**
     * Ovulation of the {@link Female} {@link Gender}
     */
    public void ovulate() {

    }

    /**
     * Menstruation of the {@link Female} {@link Gender}
     */
    public void menstruate() {

    }

    /**
     * Checks if the {@link Female} {@link Gender} is pregnant or not.
     *
     * @return If the {@link Female} {@link Gender} is pregnant or not.
     */
    @Override
    public boolean isPregnant() {
        return false;
    }

    /**
     * Propagates with 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} to propagate with.
     * @param parent2 The second {@link Animal} to propagate with.
     */
    @Override
    public void propagate(Animal parent1, Animal parent2) {

    }

    /**
     * The birth of the {@link Female} {@link Gender}.
     *
     * @return The {@link Egg}s from the birth of the {@link Female} {@link Gender}.
     */
    @Override
    public ArrayList<Egg> giveBirth() {
        return null;
    }

    /**
     * Checks if the {@link Female} {@link Gender} is a female.
     *
     * @return If the {@link Female} {@link Gender} is a female.
     */
    @Override
    public boolean isFemale() {
        return true;
    }

    /**
     * Sets the produced {@link Egg}s of the {@link Female} {@link Gender}.
     *
     * @param eggs the produced {@link Egg}s of the {@link Female} {@link Gender}.
     */
    public void setEggs(ArrayList<Egg> eggs) {
        this.eggs = eggs;
    }

    /**
     * Retrieves the produced {@link Egg}s of the {@link Female} {@link Gender}.
     *
     * @return The produced {@link Egg}s of the {@link Female} {@link Gender}.
     */
    public ArrayList<Egg> getEggs() {
        return eggs;
    }


}
