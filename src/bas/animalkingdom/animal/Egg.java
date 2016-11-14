package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * An {@link Egg}
 */
public class Egg {

    /**
     * The constructor reference for the embryo
     */
    private Constructor<? extends Animal> embryoConstructor;

    /**
     * The class arguments for the embryo
     */
    private Object[] embryoProperties;

    /**
     *
     */
    private Map<Method, Object[]> specialEmbryoPropertyMethods;

    /**
     * Checks if the {@link Egg} is inseminated or not
     *
     * @return If the {@link Egg} is inseminated or not
     */
    public boolean isInseminated() {
        return this.embryoConstructor != null && this.embryoProperties != null;
    }

    /**
     * Inseminates this {@link Egg} by 2 {@link Animal}s.
     *
     * @param parent1 The first {@link Animal} parent.
     * @param parent2 The second {@link Animal} parent.
     */
    public void inseminate(Animal parent1, Animal parent2) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if ((parent1 == null || parent2 == null)) {
            return;
        } else if (parent1.getClass() != parent2.getClass()) {
            return;
        }
        Class<? extends Animal> animalClass = parent1.getClass();

        this.embryoConstructor = animalClass.getDeclaredConstructor(Gender.class, String.class, String.class, String.class, int.class, int.class);
        this.embryoProperties = this.resolveEmbryoProperties(parent1, parent2);
        this.specialEmbryoPropertyMethods = this.resolveSpecialEmbryoPropertyMethods(parent1, parent2);
    }

    /**
     * @param parent1
     * @param parent2
     * @return
     * @throws NoSuchMethodException
     */
    private Map<Method, Object[]> resolveSpecialEmbryoPropertyMethods(Animal parent1, Animal parent2) throws NoSuchMethodException {
        HashMap<Method, Object[]> methods = new HashMap<>();


        /*
          TODO: Refactor

          - Find class in resolve table from parent1
          - Add all methods with resolved arguments into the methods hash map
         */

        //if more resolve right method do some bas-magic
        if (Human.class.isAssignableFrom(parent1.getClass())) {
            Method setInsertion = parent1.getClass().getMethod("setInsertion", String.class);

            methods.put(setInsertion, new Object[]{
                    ((Human) parent1).getInsertion()
            });

            Method setLastName = parent1.getClass().getMethod("setLastName", String.class);

            methods.put(setLastName, new Object[]{
                    ((Human) parent1).getLastName()
            });
        } else if (Elephant.class.isAssignableFrom(parent1.getClass())) {
            Method currentMethod = parent1.getClass().getMethod("setEarSize", int.class);
            if (currentMethod == null) {
                return null;
            }

            int firstEarSize = ((Elephant) parent1).getEarSize();
            int secondEarSize = ((Elephant) parent2).getEarSize();
            Object[] methodParameters = new Object[]{
                    firstEarSize - secondEarSize
            };
            methods.put(currentMethod, methodParameters);
        }

        return methods;
    }

    /**
     * @param parent1
     * @param parent2
     * @return
     */
    private Object[] resolveEmbryoProperties(Animal parent1, Animal parent2) {
        Object[] embryoProperties = new Object[6];

        Animal[] parents = {parent1, parent2};

        for (int embryoPropertyIndex = 0; embryoPropertyIndex < embryoProperties.length; embryoPropertyIndex++) {
            Object embryoProperty;

            int randomParentIndex = (new Random()).nextInt(parents.length);
            Animal randomParent = parents[randomParentIndex];

            if (embryoPropertyIndex == 0) {
                //embryoProperty = randomParent.getGender();
                embryoProperty = new Male();
            } else if (embryoPropertyIndex == 3) {
                embryoProperty = randomParent.getColor();
            } else if (embryoPropertyIndex == 4) {
                embryoProperty = (new Random()).nextInt(300);
            } else if (embryoPropertyIndex == 5) {
                embryoProperty = randomParent.getMaxNumberOfEggs();
            } else {
                embryoProperty = parent1.getClass().getSimpleName() + parent2.getClass().getSimpleName();
            }
            embryoProperties[embryoPropertyIndex] = embryoProperty;
        }
        return embryoProperties;
    }

    /**
     * The hatching of the egg, the animal gets created
     */
    public Animal hatch() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.embryoConstructor == null) {
            return null;
        }
        Animal animal = this.embryoConstructor.newInstance(this.embryoProperties);

        if (this.specialEmbryoPropertyMethods != null) {
            for (Map.Entry<Method, Object[]> specialEmbryoPropertyMethod : this.specialEmbryoPropertyMethods.entrySet()) {
                specialEmbryoPropertyMethod.getKey().invoke(animal, specialEmbryoPropertyMethod.getValue());
            }
            this.specialEmbryoPropertyMethods = null;
        }
        return animal;
    }


    public Constructor<? extends Animal> getEmbryoConstructor() {
        return embryoConstructor;
    }

    public Object[] getEmbryoProperties() {
        return embryoProperties;
    }
}