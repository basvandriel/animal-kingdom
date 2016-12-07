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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;

@Controller("Animal")
public class AnimalController {


    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public ModelAndView getAnimals(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView("overview");

        Zoo zoo = Zoo.getInstance("ICO41A");

        modelMap.put("availableAnimals", zoo.getAvailableAnimals());

        if (race.isEmpty()) {
            modelMap.put("selectedAnimals", zoo.getAllAnimals().stream().filter(animal -> !Human.class.isAssignableFrom(animal.getClass())).collect(Collectors.toList()));
        } else {
            Class<?> animalClass = Class.forName(race);
            modelMap.put("selectedAnimals", zoo.getAllAnimalsByRace((Class<? extends Animal>) animalClass));
        }

        if (race.equals(Human.class.getName())) {
            modelAndView.setViewName("humans-overview");
        } else if (race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            modelAndView.setViewName("elephants-overview");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/overview/add", method = RequestMethod.GET)
    public ModelAndView addAnimalOverview(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException {
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

        String view = "add-animal";
        if (race.equals(Human.class.getName())) {
            view = "add-human-animal";
        }

        if (race.equals(AfricanElephant.class.getName()) || race.equals(AsianElephant.class.getName())) {
            view = "add-elephant-animal";
        }

        return new ModelAndView(view);
    }


    @RequestMapping(value = "/overview/add", method = RequestMethod.POST, params = {
            "race", "gender", "bodyCovering", "name", "color", "weight", "maxNumberOfEggs"
    })
    public ModelAndView handleAddAnimal(@RequestParam(value = "race") String race,
                                        @RequestParam(value = "gender") String gender,
                                        @RequestParam(value = "bodyCovering") String bodyCovering,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "color") String color,
                                        @RequestParam(value = "weight") int weight,
                                        @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs)

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException {

        String view = "overview";
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build();
        if (animal == null) {
            view = "../../index";
        }
        return new ModelAndView("redirect:/" + view);
    }


    @RequestMapping(value = "/overview/add", method = RequestMethod.POST, params = {
            "race", "gender", "bodyCovering", "name", "color", "weight", "maxNumberOfEggs", "earSize"
    })
    public ModelAndView handleAddElephantAnimal(@RequestParam(value = "race") String race,
                                                @RequestParam(value = "gender") String gender,
                                                @RequestParam(value = "bodyCovering") String bodyCovering,
                                                @RequestParam(value = "name") String name,
                                                @RequestParam(value = "color") String color,
                                                @RequestParam(value = "weight") int weight,
                                                @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs,

                                                //Elephant properties
                                                @RequestParam(value = "earSize") int earSize)

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException {


        String view = "overview";
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build(earSize);
        if (animal == null) {
            view = "../../index";
        }

        return new ModelAndView("redirect:/" + view);
    }

    @RequestMapping(value = "/overview/add", method = RequestMethod.POST, params = {
            "race", "gender", "bodyCovering", "name", "insertion", "lastName", "color", "weight", "maxNumberOfEggs", "usingBirthControl"
    })
    public ModelAndView handleAddHumanAnimal(@RequestParam(value = "race") String race,
                                             @RequestParam(value = "gender") String gender,
                                             @RequestParam(value = "bodyCovering") String bodyCovering,
                                             @RequestParam(value = "name") String name,
                                             @RequestParam(value = "insertion") String insertion,
                                             @RequestParam(value = "lastName") String lastName,
                                             @RequestParam(value = "color") String color,
                                             @RequestParam(value = "weight") int weight,
                                             @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs,
                                             @RequestParam(value = "usingBirthControl") boolean usesBirthControl)

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException {

        String view = "overview";
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build(insertion, lastName, usesBirthControl);
        if (animal == null) {
            view = "../../index";
        }

        return new ModelAndView("redirect:/" + view);
    }
}