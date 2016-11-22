package bas.animalkingdom.zoo;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.Egg;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Cage implements Comparable<Cage> {

    /**
     * The {@link Animal} race for this {@link Cage}
     */
    private Class<? extends Animal> race;

    /**
     * The caged {@link Animal}s in this {@link Cage}.
     */
    private ArrayList<Animal> cagedAnimals;

    /**
     * @param race The {@link Animal} race
     */
    public Cage(Class<? extends Animal> race) {
        this.race = race;
        this.cagedAnimals = new ArrayList<>();

        Zoo.getInstance("ICO41A").addCage(this);
    }

    /**
     * Selects a random {@link Animal} in this {@link Cage}.
     *
     * @return A  random {@link Animal} in this {@link Cage}.
     */
    public Animal selectAnimal() {
        int randomAnimalIndex = (new Random()).nextInt(this.cagedAnimals.size());
        return cagedAnimals.get(randomAnimalIndex);
    }

    /**
     * The {@link Animal} race of this {@link Cage}.
     */
    public Class<? extends Animal> getCageRace() {
        return this.race;
    }

    /**
     * Adds a {@link Animal} in to {@link Cage}.
     *
     * @param anAnimal The {@link Animal} to add in this {@link Cage}.
     *
     * @return If the {@link Animal} in this {@link Cage} could be added.
     */
    public boolean addAnimal(Animal anAnimal) {
        if (anAnimal.getClass().isInstance(this.getCageRace())) {
            return false;
        }
        return this.cagedAnimals.add(anAnimal);
    }

    /**
     * Retrieves the caged {@link Animal}s in this {@link Cage}.
     *
     * @return The caged {@link Animal}s in this {@link Cage}.
     */
    public ArrayList<Animal> getCagedAnimals() {
        return this.cagedAnimals;
    }

    /**
     * Adds {@link Animal} reptile eggs to this {@link Cage}.
     *
     * @param reptileEggs The {@link Animal} reptile eggs to this {@link Cage}.
     */
    public void addReptileEggs(ArrayList<Egg> reptileEggs) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (reptileEggs == null || reptileEggs.size() == 0) {
            return;
        }
        for (Egg egg : reptileEggs) {
            egg.hatch();
        }
    }

    @Override
    public int compareTo(Cage cage) {
        String comparableCageType = cage.getCageRace().getSimpleName();

        String currentCageType = this.getCageRace().getSimpleName();
        if (comparableCageType.equals(currentCageType)) {
            return 0;
        }
        return currentCageType.compareTo(comparableCageType);
    }
}
