package bas.animalkingdom.animal.gender.impl;

import bas.animalkingdom.animal.Egg;

public class Female {

    /**
     *
     * @return Produces an {@link Egg}
     */
    public Egg produceEgg() {
        return new Egg();
    }
}
