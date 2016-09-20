package bas.animalkingdom.animal.gender.impl;

import bas.animalkingdom.egg.Egg;

/**
 * Created by Bas on 20-9-2016.
 */
public class Female {

    /**
     *
     * @return Produces an {@link Egg}
     */
    public Egg produceEgg() {
        return new Egg();
    }
}
