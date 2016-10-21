package bas.animalkingdom;

import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.bird.Bird;
import bas.animalkingdom.animal.impl.bird.Parrot;
import bas.animalkingdom.animal.impl.bird.Pinguin;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;
import bas.animalkingdom.animal.impl.mammal.mouse.GrayMouse;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import bas.animalkingdom.animal.impl.reptile.Reptile;
import bas.animalkingdom.animal.impl.reptile.Snake;
import bas.animalkingdom.animal.impl.special.Platypus;
import bas.animalkingdom.threads.OvulatingThread;
import bas.animalkingdom.threads.ReptileEggHatcherThread;
import bas.animalkingdom.threads.SuckleDispatcherThread;
import bas.animalkingdom.zoo.Cage;
import bas.animalkingdom.zoo.Zoo;
import sun.net.www.http.Hurryable;

/**
 *
 */
public class Starter {

    public static void main(String[] args) {
        Egg egg = new Egg();

        //Genders
        Gender male = new Male();
        Female female = new Female();

        //Birds
        Parrot parrot1 = new Parrot(new Male(), "BodyCovering1", "Jumbo the parrot1", "Gray red", 1200, 5);
        String parrot1Communication = parrot1.communicate();
        System.out.println(parrot1Communication);

        Pinguin pinguin1 = new Pinguin(new Male(), "BodyCovering1", "Jumbo the pinguin1", "Gray red", 1200, 5);
        String pinguin1Communication = pinguin1.communicate();
        System.out.println(pinguin1Communication);

        //Mammals
        Human human = new Human(new Male(), "BodyCovering1", "Jumbo the human", "Gray red", 1200, 5);
        String humanCommunication = human.communicate();
        System.out.println(humanCommunication);

        //Mouses
        Mouse mouse = new Mouse(new Male(), "BodyCovering1", "Jumbo the mouse", "Gray red", 1200, 5);
        String mouseCommunication = mouse.communicate();
        System.out.println(mouseCommunication);

        GrayMouse grayMouse = new GrayMouse(new Male(), "BodyCovering1", "Jumbo the gray mouse", "Gray red", 1200, 5);
        String grayMouseCom = grayMouse.communicate();
        System.out.println(grayMouseCom);

        WhiteMouse whiteMouse = new WhiteMouse(new Male(), "BodyCovering1", "Jumbo the white mouse", "Gray red", 1200, 5);
        String whiteMouseCom = whiteMouse.communicate();
        System.out.println(whiteMouseCom);

        //Elephants
        Elephant elephant1 = new Elephant(new Male(), "BodyCovering1", "Jumbo the elephant", "Gray red", 1200, 5, 200);
        String normalElephantCom = elephant1.communicate();
        System.out.println(normalElephantCom);

        Elephant elephant2 = new AfricanElephant(new Male(), "BodyCovering1", "Jumba the african elephant", "Gray blue", 1500, 2, 300);
        String africanElephantCom = elephant2.communicate();
        System.out.println(africanElephantCom);

        Elephant elephant3 = new AsianElephant(new Male(), "BodyCovering1", "Jumbi the asian elephant", "Gray yellow", 1400, 3, 400);
        String asianElephantCom = elephant3.communicate();
        System.out.println(asianElephantCom);

        //Reptile
        Crocodile crocodile = new Crocodile(new Male(), "BodyCovering1", "Jumbo the crocodile", "Gray red", 1200, 5);
        String crocodileCom = crocodile.communicate();
        System.out.println(crocodileCom);

        Snake snake = new Snake(new Male(), "BodyCovering1", "Jumbo the snake", "Gray red", 1200, 5);
        String snakeCom = snake.communicate();
        System.out.println(snakeCom);

        //Special
        Platypus platypus = new Platypus(new Male(), "BodyCovering1", "Jumbo the platypus", "Gray red", 1200, 5);
        String platypusCom = platypus.communicate();

        System.out.println(platypusCom);

        //Zoo
        Zoo zoo = Zoo.getInstance("ICO41A");

        //Cage
        Cage cage = new Cage(Crocodile.class);
        zoo.addCage(cage);

        //Threads
        OvulatingThread ovulatingThread = new OvulatingThread(100, female);
        ReptileEggHatcherThread reptileEggHatcherThread = new ReptileEggHatcherThread(cage);
        SuckleDispatcherThread suckleDispatcherThread = new SuckleDispatcherThread(human);
    }

}
