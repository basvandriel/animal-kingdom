package bas.animalkingdom.controllers;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.AnimalFactory;
import bas.animalkingdom.animal.impl.bird.Parrot;
import bas.animalkingdom.animal.impl.bird.Pinguin;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.mouse.GrayMouse;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import bas.animalkingdom.animal.impl.reptile.Snake;
import bas.animalkingdom.animal.impl.special.Platypus;
import bas.animalkingdom.zoo.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;

@Controller("Animal")
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

        if (race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            return "elephants-overview";
        }

        return "overview";
    }

    @RequestMapping(value = "/overview/add", method = RequestMethod.GET)
    public String addAnimalOverview(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException {
        //Add all animals which can be added
        modelMap.put("availableAnimals", new Class[]{
                Parrot.class,
                Pinguin.class,
                Human.class,
                AfricanElephant.class,
                AsianElephant.class,
                GrayMouse.class,
                WhiteMouse.class,
                Mouse.class,
                Crocodile.class,
                Snake.class,
                Platypus.class
        });

        if (race.equals(Human.class.getName())) {
            return "add-human-overview";
        }

        if (race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            return "add-elephant-animal";
        }

        return "add-animal";
    }

    @RequestMapping(value = "/overview/add", method = RequestMethod.POST)
    public String handleAddAnimal(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race,
                                  @RequestParam(value = "gender", required = false) String gender,
                                  @RequestParam(value = "bodyCovering", required = false) String bodyCovering,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "color", required = false) String color,
                                  @RequestParam(value = "weight", required = false) int weight,
                                  @RequestParam(value = "gender", required = false) int maxNumberOfEggs) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException {

        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.build(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs);

        //Add animal to list


        return "overview";
    }


}