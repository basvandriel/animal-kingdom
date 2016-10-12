package bas.animalkingdom;

import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;

/**
 *
 */
public class Starter {

    public static void main(String[] args) {
        Elephant elephant1 = new Elephant(new Male(), "BodyCovering1", "Jumbo", "Gray red", 1200, 5, 200);
        Elephant elephant2 = new AfricanElephant(new Male(), "BodyCovering1", "Jumba", "Gray blue", 1500, 2, 300);
        Elephant elephant3 = new AsianElephant(new Male(), "BodyCovering1", "Jumbi", "Gray yellow", 1400, 3, 400);


    }

}
