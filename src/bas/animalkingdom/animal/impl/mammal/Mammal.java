package bas.animalkingdom.animal.impl.mammal;


import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.threads.SuckleDispatcherThread;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * A {@link Mammal} {@link Animal}
 */
public abstract class Mammal extends Animal implements IMammal {

    /**
     * The babies for this {@link Mammal}
     */
    private ArrayList<IMammal> babies;

    /**
     * Creates a new {@link Mammal} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Mammal} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Mammal} {@link Animal}.
     * @param name            The name of the {@link Mammal} {@link Animal}.
     * @param color           The color of the {@link Mammal} {@link Animal}.
     * @param weight          The weight of the {@link Mammal} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Mammal} {@link Animal}.
     */
    public Mammal(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Gives life birth
     */
    public void giveLifeBirth() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayList<Egg> mammalEggs = this.giveBirth();
        if (mammalEggs == null || mammalEggs.size() == 0) {
            return;
        }

        this.babies = new ArrayList<>();
        for (Egg egg : mammalEggs) {
            this.babies.add((IMammal) egg.hatch());
        }
    }

    /**
     * Suckles the the {@link Mammal} {@link Animal} babies
     *
     * @param babies The {@link Mammal} {@link Animal} babies
     */
    public void suckle(ArrayList<Mammal> babies) {
        if (this.babies == null || this.babies.size() == 0) {
            return;
        }
        SuckleDispatcherThread suckleDispatcherThread = new SuckleDispatcherThread(this);
        suckleDispatcherThread.start();
    }

    /**
     * Resolves the babies from the {@link Mammal}
     *
     * @return The babies from the {@link Mammal}
     */
    public ArrayList<IMammal> getBabies() {
        return this.babies;
    }
}
