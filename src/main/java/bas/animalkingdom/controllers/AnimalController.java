package bas.animalkingdom.controllers;

import bas.animalkingdom.SpringHelper;
import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.AnimalFactory;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.bird.Parrot;
import bas.animalkingdom.animal.impl.bird.Pinguin;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.IMammal;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;
import bas.animalkingdom.animal.impl.mammal.mouse.GrayMouse;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import bas.animalkingdom.animal.impl.reptile.Snake;
import bas.animalkingdom.animal.impl.special.Platypus;
import bas.animalkingdom.repository.AnimalRepository;
import bas.animalkingdom.zoo.Zoo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller("Animal")
public class AnimalController {

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public ModelAndView getAnimals(ModelMap modelMap, @RequestParam(value = "race", required = false, defaultValue = "") String race) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
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

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException, SQLException {

        ModelAndView modelAndView = new ModelAndView("redirect:/overview");
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build();
        if (animal == null) {
            modelAndView.setViewName("redirect:/../../index");
            return modelAndView;
        }
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.addAnimal(animal);
        return modelAndView;
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

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException, SQLException {


        ModelAndView modelAndView = new ModelAndView("redirect:/overview");
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build(earSize);
        if (animal == null) {
            modelAndView.setViewName("redirect:/../../index");
            return modelAndView;
        }
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.addAnimal(animal);
        return modelAndView;
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

            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvalidClassException, NoSuchMethodException, InvocationTargetException, SQLException {

        ModelAndView modelAndView = new ModelAndView("redirect:/overview");
        Animal animal = new AnimalFactory(race, gender, bodyCovering, name, color, weight, maxNumberOfEggs).build(insertion, lastName, usesBirthControl);
        if (animal == null) {
            modelAndView.setViewName("redirect:/../../index");
            return modelAndView;
        }
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.addAnimal(animal);
        return modelAndView;
    }

    @RequestMapping(value = "/overview/delete", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean handleDeleteAnimal(HttpServletRequest httpServletRequest) throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ArrayList<Animal> animals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        //Might delete more animals

        Zoo zoo = Zoo.getInstance("ICO41A");

        if (animals == null || animals.size() <= 0) {
            return false;
        }
        AnimalRepository animalRepository = new AnimalRepository();
        for (Animal animal : animals) {
            Animal toBeDeletedAnimal = animal;
            Animal possibleToBeDeletedPartner = null;

            if (Human.class.isAssignableFrom(toBeDeletedAnimal.getClass()) && ((Human) toBeDeletedAnimal).isMarried()) {
                possibleToBeDeletedPartner = ((Human) toBeDeletedAnimal).getPartner();
            }
            zoo.deleteAnimal(toBeDeletedAnimal);

            animalRepository.updateAnimal(possibleToBeDeletedPartner);
            animalRepository.updateAnimal(toBeDeletedAnimal);

            animalRepository.deleteAnimal(toBeDeletedAnimal);
        }
        return true;
    }

    @RequestMapping(value = "/overview/edit", method = RequestMethod.GET)
    public ModelAndView handleEditOverview(ModelMap modelMap, @RequestParam(value = "uuid") String uuid) {
        ModelAndView modelAndView = new ModelAndView("edit-animal");

        Animal animal = Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(uuid));
        if (animal == null) {
            modelAndView.setViewName("redirect:/../index");
            return modelAndView;
        }

        //Add the animal for receiving all the current properties
        modelMap.put("animal", animal);

        //Add the available genders if you want to change
        modelMap.put("genders", new Class[]{
                Male.class,
                Female.class,
        });

        if (Human.class.isAssignableFrom(animal.getClass())) {
            modelAndView.setViewName("edit-human-animal");
        } else if (Elephant.class.isAssignableFrom(animal.getClass())) {
            modelAndView.setViewName("edit-elephant-animal");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/overview/edit", method = RequestMethod.POST, params = {
            "uuid", "gender", "bodyCovering", "name", "color", "weight", "maxNumberOfEggs"
    })
    public ModelAndView handleEditAnimal(@RequestParam(value = "uuid") String uuidString,
                                         @RequestParam(value = "gender") String genderString,
                                         @RequestParam(value = "bodyCovering") String bodyCovering,
                                         @RequestParam(value = "name") String name,
                                         @RequestParam(value = "color") String color,
                                         @RequestParam(value = "weight") int weight,
                                         @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs)

            throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException

    {
        ModelAndView modelAndView = new ModelAndView("redirect:/overview");

        Animal animal = Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(uuidString));

        Gender gender = (Gender) Class.forName(genderString).newInstance();
        if (animal == null || gender == null) {
            return modelAndView;
        }
        animal.setBodyCovering(bodyCovering);
        animal.setGender(gender);
        animal.setName(name);
        animal.setColor(color);
        animal.setWeight(weight);
        animal.setMaxNumberOfEggs(maxNumberOfEggs);

        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(animal);
        return modelAndView;
    }

    @RequestMapping(value = "/overview/edit", method = RequestMethod.POST, params = {
            "uuid", "gender", "bodyCovering", "name", "color", "weight", "maxNumberOfEggs", "earSize"
    })
    public ModelAndView handleEditElephantAnimal(@RequestParam(value = "uuid") String uuidString,
                                                 @RequestParam(value = "gender") String genderString,
                                                 @RequestParam(value = "bodyCovering") String bodyCovering,
                                                 @RequestParam(value = "name") String name,
                                                 @RequestParam(value = "color") String color,
                                                 @RequestParam(value = "weight") int weight,
                                                 @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs,
                                                 @RequestParam(value = "earSize") int earSize
    ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {


        ModelAndView modelAndView = new ModelAndView("redirect:/overview");

        Elephant animal = (Elephant) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(uuidString));
        Gender gender = (Gender) Class.forName(genderString).newInstance();

        if (animal == null || gender == null) {
            return modelAndView;
        }
        animal.setBodyCovering(bodyCovering);
        animal.setGender(gender);
        animal.setName(name);
        animal.setColor(color);
        animal.setWeight(weight);
        animal.setMaxNumberOfEggs(maxNumberOfEggs);
        animal.setEarSize(earSize);

        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(animal);

        return modelAndView;
    }

    @RequestMapping(value = "/overview/edit", method = RequestMethod.POST, params = {
            "uuid", "gender", "bodyCovering", "name", "insertion", "lastName", "color", "weight", "maxNumberOfEggs", "usingBirthControl"
    })
    public ModelAndView handleEditHumanAnimal(@RequestParam(value = "uuid") String uuidString,
                                              @RequestParam(value = "gender") String genderString,
                                              @RequestParam(value = "bodyCovering") String bodyCovering,
                                              @RequestParam(value = "name") String name,
                                              @RequestParam(value = "insertion") String insertion,
                                              @RequestParam(value = "lastName") String lastName,
                                              @RequestParam(value = "color") String color,
                                              @RequestParam(value = "weight") int weight,
                                              @RequestParam(value = "maxNumberOfEggs") int maxNumberOfEggs,
                                              @RequestParam(value = "usingBirthControl") boolean usingBirthControl
    ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        ModelAndView modelAndView = new ModelAndView("redirect:/overview");

        Human animal = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(uuidString));
        Gender gender = (Gender) Class.forName(genderString).newInstance();
        if (animal == null || gender == null) {
            return modelAndView;
        }

        animal.setBodyCovering(bodyCovering);
        animal.setGender(gender);
        animal.setName(name);
        animal.setInsertion(insertion);
        animal.setLastName(lastName);
        animal.setColor(color);
        animal.setWeight(weight);
        animal.setMaxNumberOfEggs(maxNumberOfEggs);
        animal.setUsesBirthControl(usingBirthControl);

        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(animal);
        return modelAndView;
    }

    private ArrayList<String> parseHumanUUIDs(HttpServletRequest httpServletRequest) throws IOException {
        Gson gson = new Gson();
        List<String> humanUUIDs = gson.fromJson(
                SpringHelper.getAjaxStringFromRequest(httpServletRequest), (new TypeToken<List<String>>() {
                }).getType());

        if (humanUUIDs.size() <= 0) {
            return null;
        }
        return (ArrayList<String>) humanUUIDs;
    }

    private ArrayList<Animal> getAnimalsByUUIDs(ArrayList<String> humanUUIDs) {
        ArrayList<Animal> animals = new ArrayList<>();
        if (humanUUIDs == null) {
            return animals;
        }
        for (String humanUUID : humanUUIDs) {
            Animal animal = Zoo.getInstance().getAnimalByUUID(UUID.fromString(humanUUID));
            if (animal == null) {
                return null;
            }
            animals.add(animal);
        }
        return animals;
    }


    @RequestMapping(value = "/overview/marry", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean handleMarry(HttpServletRequest httpServletRequest) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<Animal> humans = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        if (humans == null) {
            return false;
        }
        ((Human) humans.get(0)).mary((Human) humans.get(1));

        //Update the database
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(humans.get(0));
        animalRepository.updateAnimal(humans.get(1));
        return true;
    }

    @RequestMapping(value = "/overview/canMarry", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean canMarry(HttpServletRequest httpServletRequest) throws IOException {
        //Get all the humans parsed by the given human UUIDS
        ArrayList<Animal> humans = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));

        if (humans == null) {
            return false;
        }

        Human human1 = (Human) humans.get(0);
        Human human2 = (Human) humans.get(1);


        boolean oneHasPartner = (human1.getPartner() != null && human2.getPartner() == null) ||
                (human1.getPartner() == null && human2.getPartner() != null);

        boolean bothHasOtherPartner = (human1.getPartner() != human2 && human1.getPartner() != null) &&
                (human2.getPartner() != human1 && human2.getPartner() != null);

        return !(oneHasPartner || bothHasOtherPartner);
    }

    @RequestMapping(value = "/overview/isMarriedTo", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean isMarriedTo(HttpServletRequest httpServletRequest) throws IOException {
        //Get all the humans parsed by the given human UUIDS
        ArrayList<Animal> humans = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));

        //If there are no humans found, or both doesn't have a partner, no option for marriage is possible
        if (humans == null || (((Human) humans.get(0)).getPartner() == null && ((Human) humans.get(1)).getPartner() == null)) {
            return false;
            //If one of them has a partner, marriage is not possible
        }
        //If the human's partner is the other human, the human is married to this other human
        return ((Human) humans.get(0)).getPartner() == ((Human) humans.get(1));
    }

    @RequestMapping(value = "/overview/divorce", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean divorce(HttpServletRequest httpServletRequest) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<Animal> humans = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        if (humans == null || ((Human) humans.get(0)).getPartner() == null
                || ((Human) humans.get(1)).getPartner() == null || ((Human) humans.get(0)).getPartner() != ((Human) humans.get(1))) {
            return false;
        }
        ((Human) humans.get(0)).divorce();

        //Update the database
        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(humans.get(0));
        animalRepository.updateAnimal(humans.get(1));
        return true;
    }

    @RequestMapping(value = "/overview/canPropagate", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean canPropagate(HttpServletRequest httpServletRequest) throws IOException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        return nonHumanAnimals != null && (nonHumanAnimals.get(0).getClass() == nonHumanAnimals.get(1).getClass());
    }

    @RequestMapping(value = "/overview/propagate", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean propagate(HttpServletRequest httpServletRequest) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));

        //If the animals are not from the same race, they can't propagate
        if (nonHumanAnimals == null || (nonHumanAnimals.get(0).getClass() != nonHumanAnimals.get(1).getClass())) {
            return false;
        }
        nonHumanAnimals.get(0).propagate(nonHumanAnimals.get(1));
        return true;
    }

    @RequestMapping(value = "/overview/isPregnant", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean isPregnant(HttpServletRequest httpServletRequest) throws IOException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        return nonHumanAnimals != null && nonHumanAnimals.get(0).isPregnant();
    }

    @RequestMapping(value = "/overview/giveBirth", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean giveBirth(HttpServletRequest httpServletRequest) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, SQLException, ClassNotFoundException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        if (nonHumanAnimals == null) {
            return false;
        }

        ArrayList<Egg> eggs = nonHumanAnimals.get(0).giveBirth();
        if (eggs == null || eggs.size() <= 0) {
            return false;
        }

        AnimalRepository animalRepository = new AnimalRepository();
        for (Egg egg : eggs) {
            animalRepository.addAnimal(egg.hatch());
        }
        return true;
    }

    @RequestMapping(value = "/overview/makeLove", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean makeLove(HttpServletRequest httpServletRequest) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SQLException, ClassNotFoundException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        if (nonHumanAnimals == null) {
            return false;
        }

        AnimalRepository animalRepository = new AnimalRepository();
        //Self love
        if (nonHumanAnimals.size() == 1) {
            ((Human) nonHumanAnimals.get(0)).makeLove((Human) nonHumanAnimals.get(0));
            animalRepository.updateAnimal(nonHumanAnimals.get(0));
            return true;
        }

        //Make love to partner or cheating
        if (nonHumanAnimals.size() == 2) {
            ((Human) nonHumanAnimals.get(0)).makeLove((Human) nonHumanAnimals.get(1));
            animalRepository.updateAnimal(nonHumanAnimals.get(0));
            animalRepository.updateAnimal(nonHumanAnimals.get(1));
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/overview/giveLifeBirth", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean giveLifeBirth(HttpServletRequest httpServletRequest) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SQLException, ClassNotFoundException {
        ArrayList<Animal> nonHumanAnimals = this.getAnimalsByUUIDs(this.parseHumanUUIDs(httpServletRequest));
        if (nonHumanAnimals == null) {
            return false;
        }

        Human human = (Human) nonHumanAnimals.get(0);
        human.giveLifeBirth();

        AnimalRepository animalRepository = new AnimalRepository();
        animalRepository.updateAnimal(human);

        ArrayList<IMammal> babies = human.getBabies();
        if (babies == null || babies.size() <= 0) {
            return false;
        }

        for (IMammal mammal : babies) {
            animalRepository.addAnimal((Animal) mammal);
        }
        return true;
    }

    @RequestMapping(value = "/overview/human", method = RequestMethod.GET)
    public ModelAndView getDetailedHumanOverview(ModelMap modelMap, @RequestParam(value = "uuid") String uuidString) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView("human-detailed-overview");

        Human animal = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(uuidString));
        if (animal == null) {
            modelAndView.setViewName("/overview");
        }
        modelMap.put("human", animal);
        return modelAndView;
    }

}