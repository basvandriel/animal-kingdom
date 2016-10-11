package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * A {@link Zoo}
 */
public class Zoo {

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
     * @param name  The name of the {@link Zoo}.
     * @param cages The {@link Cage}'s in this {@link Zoo}.
     */
    public Zoo(String name, ArrayList<Cage> cages) {
        this.name = name;
        this.cages = cages;
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
    public Zoo getInstance(String zoo) {
        return this;
    }

    /**
     * Gets the instance of the current {@link Zoo}.
     *
     * @return The current {@link Zoo}.
     */
    public Zoo getInstance() {
        return this;
    }

    /**
     * Adds a {@link Cage} to this {@link Zoo}.
     *
     * @param cage The {@link Cage} to add to the {@link Zoo}.
     *
     * @return If the {@link Cage} has been added to the {@link Zoo}
     */
    public boolean addCage(Cage cage) {
        return false;
    }

    /**
     * Adds a {@link Animal} to this {@link Zoo}.
     *
     * @param animal The {@link Animal} to add to the {@link Zoo}.
     *
     * @return If the {@link Animal} has been added to the {@link Zoo}
     */
    public boolean addAnimal(Animal animal) {
        return false;
    }

    /**
     * Retrieves the {@link Cage} of a specific {@link Animal}.
     *
     * @param anAnimal The {@link Animal} to retrieve the cage for.
     *
     * @return The {@link Cage} of a specific {@link Animal}.
     */
    public Cage getCageOfAnimal(Animal anAnimal) {
        return new Cage();
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
        cages.add(new Cage());

        return cages;
    }

    /**
     * Retrieves the {@link Cage}s of specific {@link Animal} species.
     *
     * @param species The {@link Animal} species to retrieve the cages for.
     *
     * @return The {@link Cage}s of specific {@link Animal} species
     */
    public TreeSet<Cage> getCageBySpecies(Class<? extends Animal> species) {
        TreeSet<Cage> cages = new TreeSet<>();
        cages.add(new Cage());

        return cages;
    }

    /**
     * Retrieves the {@link Cage} of specific {@link Animal} race.
     *
     * @param race The {@link Animal} raace to retrieve the cage for.
     *
     * @return The {@link Cage} of specific {@link Animal} race.
     */
    public Cage getCageByRace(Class<? extends Animal> race) {
        return new Cage();
    }

    /**
     * Retrieves the {@link Animal}s of a specific {@link Animal} race.
     *
     * @param race The {@link Animal} race to retrieve the {@link Animal}s for.
     *
     * @return The {@link Animal}s of a specific {@link Animal} race.
     */
    public ArrayList<Animal> getAllAnimalsByRace(Class<? extends Animal> race) {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    /**
     * Retrieves the {@link Animal}s of a specific {@link Animal} species.
     *
     * @param species The {@link Animal} species to retrieve the {@link Animal}s for.
     *
     * @return The {@link Animal}s of a specific {@link Animal} species.
     */
    public ArrayList<Animal> getAllAnimalsBySpecies(Class<? extends Animal> species) {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    /**
     * Retrieves all the {@link Animal}s.
     *
     * @return All the {@link Animal}s.
     */
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    /**
     * Adds {@link Animal} eggs.
     *
     * @param reptileEggs The {@link Animal} eggs to add
     */
    public void addEggsOfReptiles(ArrayList<Egg> reptileEggs) {

    }

}
