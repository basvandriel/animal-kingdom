package bas.animalkingdom.animal.impl.mammal;

import bas.animalkingdom.animal.Animal;

import java.util.ArrayList;

/**
 * An {@link IMammal} interface for an {@link Animal} who is a {@link Mammal}.
 */
public interface IMammal {

    /**
     * Suckles the The {@link Mammal} {@link Animal} babies to suckle
     *
     * @param babies The {@link Mammal} {@link Animal} babies
     */
    public void suckle(ArrayList<Mammal> babies);
}
