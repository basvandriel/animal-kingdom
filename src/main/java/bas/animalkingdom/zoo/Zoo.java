package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;
import bas.animalkingdom.animal.impl.bird.Bird;
import bas.animalkingdom.animal.impl.mammal.Mammal;
import bas.animalkingdom.animal.impl.reptile.Reptile;
import bas.animalkingdom.service.AnimalService;
import bas.animalkingdom.threads.ReptileEggHatcherThread;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.*;

/**
 * A {@link Zoo}
 */
public class Zoo {

    @Autowired
    private static AnimalService animalService;

    /**
     *
     */
    private static Zoo instance = null;

    /**
     * The name of the {@link Zoo}.
     */
    private String name;

    /**
     * The {@link Cage}'s in this {@link Zoo}.
     */
    private ArrayList<Cage> cages;

    /**
     * Creates a new {@link Zoo}.
     *
     * @param name The name of the {@link Zoo}.
     */
    private Zoo(String name) {
        this();
        this.name = name;
    }

    /**
     * Creates a new {@link Zoo}.
     */
    private Zoo() {
        this.cages = new ArrayList<>();
    }

    /**
     * Retrieves the name of the {@link Zoo}.
     *
     * @return The name of the {@link Zoo}.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the {@link Cage}'s in this {@link Zoo}.
     *
     * @return The {@link Cage}'s in this {@link Zoo}.
     */
    public ArrayList<Cage> getCages() {
        return cages;
    }

    /**
     * Gets the instance of a specific {@link Zoo}.
     *
     * @param zoo The {@link Zoo} name.
     *
     * @return A specific {@link Zoo}.
     */
    public static Zoo getInstance(String zoo) {
        if (instance == null) {
            instance = new Zoo(zoo);
        }
        return instance;
    }

    /**
     * Gets the instance of the current {@link Zoo}.
     *
     * @return The current {@link Zoo}.
     */
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    /**
     * Adds a {@link Cage} to this {@link Zoo}.
     *
     * @param cage The {@link Cage} to add to the {@link Zoo}.
     *
     * @return If the {@link Cage} has been added to the {@link Zoo}
     */
    public boolean addCage(Cage cage) {
        if (cage == null) {
            return false;
        }
        return this.cages.add(cage);
    }

    /**
     * Adds a {@link Animal} to this {@link Zoo}.
     *
     * @param animal The {@link Animal} to add to the {@link Zoo}.
     *
     * @return If the {@link Animal} has been added to the {@link Zoo}
     */
    public boolean addAnimal(Animal animal) {
        Cage cage = this.getCageOfAnimal(animal);
        if (cage == null) {
            cage = new Cage(animal.getClass());
            return cage.addAnimal(animal);
        }
        return cage.addAnimal(animal);
    }

    /**
     * Deletes a {@link Animal} from this {@link Zoo}.
     *
     * @param animal The {@link Animal} to delete from the {@link Zoo}.
     *
     * @return If the {@link Animal} has been been deleted from the {@link Zoo}
     */
    public boolean deleteAnimal(Animal animal) {
        Cage cage = this.getCageOfAnimal(animal);
        if (cage == null) {
            return false;
        }
        boolean hasDeleted = cage.deleteAnimal(animal);
        if (cage.getCagedAnimals().size() == 0) {
            this.cages.remove(cage);
        }
        return hasDeleted;
    }


    /**
     * Retrieves the {@link Cage} of a specific {@link Animal}.
     *
     * @param anAnimal The {@link Animal} to retrieve the cage for.
     *
     * @return The {@link Cage} of a specific {@link Animal}.
     */
    public Cage getCageOfAnimal(Animal anAnimal) {
        return this.getCageByRace(anAnimal.getClass());
    }

    /**
     * Retrieves the {@link Cage}s of a specific {@link Animal} by its species.
     *
     * @param anAnimal The {@link Animal} to retrieve the cages for.
     *
     * @return The {@link Cage}s of a specific {@link Animal} by its species.
     */
    public TreeSet<Cage> getCagesBySpeciesOfAnimal(Animal anAnimal) {
        TreeSet<Cage> cages = new TreeSet<>();
        //cages.add(new Cage());

        return cages;
    }

    /**
     * Retrieves the {@link Cage}s of specific {@link Animal} species.
     *
     * @param species The {@link Animal} species to retrieve the cages for.
     *
     * @return The {@link Cage}s of specific {@link Animal} species
     */
    public TreeSet<Cage> getCagesBySpecies(Class<? extends Animal> species) {
        TreeSet<Cage> cages = new TreeSet<>();

        //The available species
        ArrayList<Class<? extends Animal>> allSpecies = new ArrayList<>();
        allSpecies.add(Animal.class);
        allSpecies.add(Mammal.class);
        allSpecies.add(Reptile.class);
        allSpecies.add(Bird.class);

        //Check if te species class reference is not abstract or doesn't contain any of the available species
        if (!Modifier.isAbstract(species.getModifiers()) || !allSpecies.contains(species)) {
            return cages;
        }

        for (Cage cage : this.cages) {
            Class<? extends Animal> cageRace = cage.getCageRace();
            if (!species.isAssignableFrom(cageRace)) {
                continue;
            }
            //System.out.println("just added the " + cageRace);
            cages.add(cage);
        }
        return cages;
    }

    /**
     * Retrieves the {@link Cage} of specific {@link Animal} race.
     *
     * @param race The {@link Animal} race to retrieve the cage for.
     *
     * @return The {@link Cage} of specific {@link Animal} race.
     */
    public Cage getCageByRace(Class<? extends Animal> race) {
        for (Cage cage : this.cages) {
            Class<? extends Animal> cageRace = cage.getCageRace();
            String simpleClassName = cageRace.getSimpleName();
            if (!simpleClassName.equals(race.getSimpleName())) {
                continue;
            }
            return cage;
        }
        return null;
    }

    /**
     * Retrieves the {@link Animal}s of a specific {@link Animal} race.
     *
     * @param race The {@link Animal} race to retrieve the {@link Animal}s for.
     *
     * @return The {@link Animal}s of a specific {@link Animal} race.
     */
    public ArrayList<Animal> getAllAnimalsByRace(Class<? extends Animal> race) {
        if (Modifier.isAbstract(race.getModifiers())) {
            return null;
        }
        Cage cageForRace = this.getCageByRace(race);
        return cageForRace.getCagedAnimals();
    }

    /**
     * Retrieves the {@link Animal}s of a specific {@link Animal} species.
     *
     * @param species The {@link Animal} species to retrieve the {@link Animal}s for.
     *
     * @return The {@link Animal}s of a specific {@link Animal} species.
     */
    public ArrayList<Animal> getAllAnimalsBySpecies(Class<? extends Animal> species) {
        ArrayList<Animal> animalsBySpecies = new ArrayList<>();

        if (!Modifier.isAbstract(species.getModifiers())) {
            return animalsBySpecies;
        }

        TreeSet<Cage> cagesBySpecies = this.getCagesBySpecies(species);
        for (Cage cageBySpecies : cagesBySpecies) {
            ArrayList<Animal> cagedAnimals = cageBySpecies.getCagedAnimals();
            if (cagedAnimals.size() <= 0) {
                continue;
            }
            animalsBySpecies.addAll(cagedAnimals);
        }
        return animalsBySpecies;
    }

    public Set<Class<? extends Animal>> getAvailableAnimals() {
        Set<Class<? extends Animal>> availableAnimals = new HashSet<>();
        for (Animal animal : this.getAllAnimals()) {
            if (availableAnimals.contains(animal.getClass())) {
                continue;
            }
            availableAnimals.add(animal.getClass());
        }
        return availableAnimals;
    }

    /**
     * Retrieves all the {@link Animal}s.
     *
     * @return All the {@link Animal}s.
     */
    public ArrayList<Animal> getAllAnimals() {
        return this.getAllAnimalsBySpecies(Animal.class);
    }

    /**
     * Adds {@link Animal} eggs.
     *
     * @param reptileEggs The {@link Animal} eggs to add
     */
    public void addEggsOfReptiles(ArrayList<Egg> reptileEggs) {
        if (reptileEggs.size() == 0) {
            return;
        }
        Class<? extends Animal> reptileRaceClass = reptileEggs.get(0).getEmbryoConstructor().getDeclaringClass();
        Cage reptileCage = this.getCageByRace(reptileRaceClass);

        ReptileEggHatcherThread reptileEggHatcherThread = new ReptileEggHatcherThread(reptileCage, reptileEggs);
        reptileEggHatcherThread.start();
    }

    private static void loadAnimals() {
/*        AfricanElephant africanElephant = new AfricanElephant(new Male(), "Body Covering", "africanElephant", " acolor", 123, 321);
        Mouse whiteMouse = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
        Mouse whiteMouse1 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
        Mouse whiteMous2 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
        Mouse whiteMous3 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
        Mouse whiteMouse4 = new WhiteMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);
        Mouse whiteMouse5 = new GrayMouse(new Male(), "Body Covering", "anMouse", " acolor", 123, 321);

        AfricanElephant africanElephant1 = new AfricanElephant(new Male(), "Body Covering", "afed", " acolor", 123, 321);
        africanElephant1.setEarSize(214);

        AsianElephant asianElephant = new AsianElephant(new Male(), "Body Covering", "afed", " acolor", 123, 321);
        asianElephant.setEarSize(20123);


        Human human = new Human(new Male(), "a humans bodycovinerg", "Bas van Driel", "Whiteboy", 70, 1);
        Human human1 = new Human(new Male(), "a humans bodycovinerg", "Noone the human", "Black", 70, 1);
        Human human2 = new Human(new Male(), "a humans bodycovinerg", "Mr Slave", "Yellow", 70, 1);

        human.mary(human2);*/
    }

    public Animal getAnimalByUUID(UUID uuid) {
        Optional<Animal> animalByUUID = this.getAllAnimals().stream().filter(animal -> animal.getUuid().toString().equals(uuid.toString())).findFirst();
        if (!animalByUUID.isPresent()) {
            return null;
        }
        return animalByUUID.get();
    }
}
