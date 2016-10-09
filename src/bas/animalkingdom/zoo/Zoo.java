package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Bas on 20-9-2016.
 */
public class Zoo {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private ArrayList<Cage> cages;

    public Zoo(String name, ArrayList<Cage> cages) {
        this.name = name;
        this.cages = cages;
    }

    public Zoo getInstance(String zoo) {
        return this;
    }

    public Zoo getInstance() {
        return this;
    }

    public boolean addCage(Cage cage) {
        return false;
    }

    public boolean addAnimal(Animal animal) {
        return false;
    }

    public Cage getCageOfAnimal(Animal anAnimal) {
        return new Cage();
    }

    public TreeSet<Cage> getCagesBySpeciesOfAnimal(Animal anAnimal) {
        TreeSet<Cage> cages = new TreeSet<>();
        cages.add(new Cage());

        return cages;
    }

    public TreeSet<Cage> getCageBySpecies(Class<? extends Animal> species) {
        TreeSet<Cage> cages = new TreeSet<>();
        cages.add(new Cage());

        return cages;
    }

    public Cage getCageByRace(Class<? extends Animal> race) {
        return new Cage();
    }

    public ArrayList<Animal> getAllAnimalsByRace(Class<? extends Animal> race) {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    public ArrayList<Animal> getAllAnimalsBySpecies(Class<? extends Animal> species) {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        return animals;
    }

    public void addEggsOfReptiles(ArrayList<Egg> reptileEggs) {

    }

}
