package bas.animalkingdom.animal.gender.impl;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Female extends Gender {

    private ArrayList<Egg> eggs;
    
    /**
     * @return Produces an {@link Egg}
     */
    public ArrayList<Egg> produceEggs() {
        ArrayList<Egg> eggs = new ArrayList<>();
        eggs.add(new Egg());
        return eggs;
    }

    public void ovulate() {

    }

    public void menstruate() {

    }
}
