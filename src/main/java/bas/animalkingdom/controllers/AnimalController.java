package bas.animalkingdom.controllers;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.zoo.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("AnimalC")
public class AnimalController {

    @RequestMapping(value = "/animals", method = RequestMethod.GET)
    public String getAnimals(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException {
        if (race.isEmpty()) {
            modelMap.put("animals", Zoo.getInstance("ICO41A").getAllAnimals());

        } else {
            Class<? extends Animal> animalClass = (Class<? extends Animal>) Class.forName(race);
            modelMap.put("animals", Zoo.getInstance("ICO41A").getAllAnimalsByRace(animalClass));
        }

        return "animals";
    }
}
