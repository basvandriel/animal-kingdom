package bas.animalkingdom.animal.impl.special;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.bird.IBird;
import bas.animalkingdom.animal.impl.mammal.IMammal;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.impl.reptile.IReptile;

import java.util.ArrayList;

/**
 * A special {@link Platypus} {@link Animal}.
 */
public class Platypus extends Animal implements IBird, IMammal, IReptile {

    /**
     * Creates a new {@link Platypus} {@link Animal}.
     *
     * @param gender          The {@link Gender} of the {@link Platypus} {@link Animal}.
     * @param bodyCovering    The body covering of the {@link Platypus} {@link Animal}.
     * @param name            The name of the {@link Platypus} {@link Animal}.
     * @param color           The color of the {@link Platypus} {@link Animal}.
     * @param weight          The weight of the {@link Platypus} {@link Animal}.
     * @param maxNumberOfEggs The max number of eggs of the {@link Platypus} {@link Animal}.
     */
    public Platypus(Gender gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        super(gender, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    /**
     * Suckles the The {@link Mammal} {@link Animal} babies to suckle
     *
     * @param babies The {@link Mammal} {@link Animal} babies
     */
    @Override
    public void suckle(ArrayList<Mammal> babies) {

    }

    /**
     * Resolves the crawling of the {@link Platypus} {@link IReptile}
     *
     * @return The crawling of the {@link Platypus} {@link IReptile}
     */
    @Override
    public String crawl() {
        return null;
    }


    /**
     * Hatches the laid eggs
     *
     * @param layedEggs The laid eggs
     */
    @Override
    public void hatchEggs(ArrayList<Egg> layedEggs) {

    }

    /**
     * Resolves the string how the {@link Platypus} communicates
     *
     * @return The string how the {@link Platypus} communicates
     */
    @Override
    public String communicate() {
        return null;
    }

    /**
     * Lay eggs
     *
     * @return eggs The eggs that has been laid.
     */
    @Override
    public ArrayList<Egg> layEggs() {
        return null;
    }

    /**
     * Resolves the flying of the {@link Platypus}
     *
     * @return The flying of the {@link Platypus}
     */
    @Override
    public String fly() {
        return null;
    }
}
