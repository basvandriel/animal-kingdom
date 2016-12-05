package bas.animalkingdom.controllers;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.AnimalFactory;
import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
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

        modelMap.put("genders", new Class[]{
                Male.class,
                Female.class,
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
    public String handleAddAnimal(@RequestParam(value = "race", required = false, defaultValue = "") String race,
                                  @RequestParam(value = "gender") String gender,
                                  @RequestParam(value = "bodyCovering") String bodyCovering,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "color") String color,
                                  @RequestParam(value = "weight") int weight,
                                  @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs,

                                  //Elephant properties
                                  @RequestParam(value = "earSize", required = false) int earSize,

                                  //Human properties
                                  @RequestParam(value = "insertion", required = false) String insertion,
                                  @RequestParam(value = "lastName", required = false) String lastName,
                                  @RequestParam(value = "usesBirthControl", required = false) boolean usesBirthControl)

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException {
        AnimalFactory animalFactory = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs);

        Animal animal = null;
        if (race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            animal = animalFactory.build(earSize);
        } else if (race.equals(Human.class.getName())) {
            animal = animalFactory.build(insertion, lastName, usesBirthControl);
        }

        if (animal == null) {
            return "/";
        }

        return "overview";
    }
}