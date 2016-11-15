package bas.animalkingdom.animal.impl.mammal;

import java.util.ArrayList;

/**
 * An {@link IMammal} interface for an {@link bas.animalkingdom.animal.Animal} who is a {@link bas.animalkingdom.animal.Animal}.
 */
public interface IMammal {

    /**
     * Suckles the {@link Mammal} {@link bas.animalkingdom.animal.Animal} babies
     *
     * @param babies The {@link Mammal} {@link bas.animalkingdom.animal.Animal} babies
     */
    public void suckle(ArrayList<Mammal> babies);
}
