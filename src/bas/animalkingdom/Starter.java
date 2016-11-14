package bas.animalkingdom;

import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Human;

import java.lang.reflect.InvocationTargetException;

/**
 *
 */
public class Starter {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        //Test for UE003
/*        Bird bird = new Parrot(new Male(), "BodyCovering1", "Parrot the Normal Male", "Gray red", 1200, 0);
        Bird pinguin = new Pinguin(new Male(), "BodyCovering1", "Parrot the Normal Male", "Gray red", 1200, 0);

        System.out.println(bird.fly());
        System.out.println(pinguin.fly());

        Reptile crocodile = new Crocodile(new Male(), "BodyCovering1", "Crocodile the Normal Male", "Gray red", 1200, 0);
        Reptile snake = new Snake(new Male(), "BodyCovering1", "Snake the Normal Male", "Gray red", 1200, 0);

        System.out.println(crocodile.crawl());
        System.out.println(snake.crawl());

        Human theMale = new Human(new Male(), "BodyCovering1", "Human the Normal Male", "Gray red", 1200, 0);
        Human theFemaleMale = new Human(new Male(), "BodyCovering1", "Human the Normal MMale Female", "Gray", 1200, 5);

        theMale.mary(theFemaleMale);

        theMale.divorce();*/

        //UE004

        //Human propagatingFemale = new Human(new Female(), "BodyCovering1", "Human the Normal MMale Female", "Gray", 1200, 5);

        Human marriedMale = new Human(new Male(), "BodyCovering1", "Human the Normal Male", "Gray red", 1200, 0);
        Human singleMale = new Human(new Male(), "BodyCovering1", "Human the Normal MMale Female", "Gray", 1200, 5);

        Human marriedFemale = new Human(new Male(), "BodyCovering1", "Human the Normal MMale Female", "Gray", 1200, 5);

        marriedMale.mary(marriedFemale);

        marriedFemale.makeLove(marriedMale);
    }

}
