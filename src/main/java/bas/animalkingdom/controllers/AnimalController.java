package bas.animalkingdom.controllers;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.zoo.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller("AnimalC")
public class AnimalController {

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String getAnimals(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException {
        Zoo zoo = Zoo.getInstance("ICO41A");

        modelMap.put("availableAnimals", zoo.getAvailableAnimals());

        if (race.isEmpty()) {
            modelMap.put("selectedAnimals", zoo.getAllAnimals().stream().filter(animal -> !Human.class.isAssignableFrom(animal.getClass())).collect(Collectors.toList()));
        } else {
            Class<?> animalClass = Class.forName(race);
            modelMap.put("selectedAnimals", zoo.getAllAnimalsByRace((Class<? extends Animal>) animalClass));
        }

        if (race.equals(Human.class.getName())) {
            return "humans-overview";
        }
		
		if(race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            return "elephants-overview";
		}

        return "overview";
    }

}