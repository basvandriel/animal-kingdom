package bas.animalkingdom.animal.impl.mammal;


import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Male;

import java.util.ArrayList;

/**
 * A {@link Mammal} {@link Animal}
 */
public abstract class Mammal extends Animal implements IMammal {

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
    public void giveLifeBirth() {

    }

    /**
     * Resolves the babies from the {@link Mammal}
     *
     * @return The babies from the {@link Mammal}
     */
    public ArrayList<IMammal> getBabies() {
        ArrayList<IMammal> babies = new ArrayList<>();
        //babies.add(new Human(new Male()));
        return babies;
    }
}
