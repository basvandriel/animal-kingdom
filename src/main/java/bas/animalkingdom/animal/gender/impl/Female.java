package bas.animalkingdom.animal.gender.impl;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.threads.OvulatingThread;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A {@link Female} {@link Gender}
 */
public class Female extends Gender {

    /**
     * The {@link OvulatingThread} for the {@link Female} {@link Gender}.
     */
    private OvulatingThread ovulatingThread;

    /**
     * The produced {@link Egg}s of the {@link Female} {@link Gender}.
     */
    private ArrayList<Egg> eggs;

    /**
     * Creates a new {@link Female} {@link Gender}.
     */
    public Female() {
        this.eggs = new ArrayList<>();

        int initialDelay = ((new Random()).nextInt(10)) * 1000;
        this.ovulatingThread = new OvulatingThread(initialDelay, this);
        this.ovulatingThread.start();
    }

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
        if (this.isPregnant()) {
            System.out.println("Cant ovuluate because pregnant");
            return;
        }
        int maxNumbersOfEgs = this.getGenderOwner().getMaxNumberOfEggs();

        for (int eggs = 0; eggs < maxNumbersOfEgs; eggs++) {
            this.eggs.add(new Egg());
        }
        System.out.println("ovululated\n");
    }

    /**
     * Menstruation of the {@link Female} {@link Gender}
     */
    public void menstruate() {
        if (this.isPregnant()) {
            System.out.println("Cant menstruate because pregnant");
            return;
        }
        this.eggs.clear();
        System.out.println("mensturated\n\n");
    }

    private List<Egg> getInseminatedEggs() {
        return this.eggs.stream().filter(
                Egg::isInseminated
        ).collect(Collectors.toList());
    }

    private boolean hasInseminatedEggs() {
        return this.getInseminatedEggs().size() != 0;
    }

    /**
     * Checks if the {@link Female} {@link Gender} is pregnant or not.
     *
     * @return If the {@link Female} {@link Gender} is pregnant or not.
     */
    @Override
    public boolean isPregnant() {
        return this.hasInseminatedEggs();
    }

    /**
     * Propagates with 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} to propagate with.
     * @param parent2 The second {@link Animal} to propagate with.
     */
    @Override
    public void propagate(Animal parent1, Animal parent2) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if ((parent1.isFemale() && parent2.isFemale()) || (parent1.isPregnant() || parent2.isPregnant())) {
            System.out.println("can't propagate");
            return;
        }
        for (Egg egg : this.eggs) {
            egg.inseminate(parent1, parent2);
        }
        System.out.println();
    }

    /**
     * The birth of the {@link Female} {@link Gender}.
     *
     * @return The {@link Egg}s from the birth of the {@link Female} {@link Gender}.
     */
    @Override
    public ArrayList<Egg> giveBirth() {
        if (!this.isPregnant()) {
            return null;
        }
        return (ArrayList<Egg>) this.getInseminatedEggs();
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
