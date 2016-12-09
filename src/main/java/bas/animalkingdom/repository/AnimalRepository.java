package bas.animalkingdom.repository;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class AnimalRepository {

    private static ArrayList<Animal> animals;

    static {
        animals = new ArrayList<Animal>() {

            {
                AfricanElephant africanElephant = new AfricanElephant(new Male(), "Body Covering", "africanElephant", " acolor", 123, 321);
                AfricanElephant africanElephant1 = new AfricanElephant(new Male(), "Body Covering", "afed", " acolor", 123, 321);

                africanElephant1.setEarSize(214);

                Mouse whiteMouse = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
                Mouse whiteMouse1 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
                Mouse whiteMous2 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
                Mouse whiteMous3 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);


                AsianElephant asianElephant = new AsianElephant(new Male(), "Body Covering", "afed", " acolor", 123, 321);
                asianElephant.setEarSize(20123);

                Human human = new Human(new Male(), "a humans bodycovinerg", "Bas van Driel", "Whiteboy", 70, 1);
                Human human1 = new Human(new Male(), "a humans bodycovinerg", "Noone the human", "Black", 70, 1);
                Human human2 = new Human(new Male(), "a humans bodycovinerg", "Max van Driel", "Yellow", 70, 1);
                Human human4 = new Human(new Male(), "a humans bodycovinerg", "Mini me", "Yellow", 70, 1);


                add(africanElephant1);
                add(africanElephant);

                add(whiteMouse);
                add(whiteMouse1);
                add(whiteMous2);
                add(whiteMous3);
                add(human);
                add(human1);
                add(human2);
                add(human4);
            }
        };
    }

    public Collection<Animal> getAllAnimals() {
        return this.animals;
    }
}
