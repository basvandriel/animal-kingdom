package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;

import java.io.InvalidClassException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class AnimalFactory {

    private String race;

    private String gender;
    private String bodyCovering;
    private String name;
    private String color;
    private int weight;
    private int maxNumberOfEggs;

    public AnimalFactory(String race, String gender, String bodyCovering, String name, String color, int weight, int maxNumberOfEggs) {
        this.race = race;
        this.gender = gender;
        this.bodyCovering = bodyCovering;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxNumberOfEggs = maxNumberOfEggs;
    }

    public Animal build() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvalidClassException, NoSuchMethodException, InvocationTargetException {
        Class<?> raceClass = Class.forName(this.race);

        Constructor<?> animalConstructor = raceClass.getConstructor(Gender.class, String.class, String.class, String.class, int.class, int.class);
        if (Animal.class.isAssignableFrom(animalConstructor.getClass())) {
            throw new InvalidClassException("Can't find an Animal class");
        }

        Gender genderObject = (Gender) Class.forName(gender).newInstance();

        return (Animal) animalConstructor.newInstance(genderObject, bodyCovering, name, color, weight, maxNumberOfEggs);
    }

    public Animal build(int earSize) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvalidClassException, NoSuchMethodException, InvocationTargetException {
        Elephant animal = (Elephant) this.build();
        //Todo check if its a elephant type
        animal.setEarSize(earSize);
        return animal;
    }

    public Animal build(String insertion, String lastName, boolean usesBirthControl) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvalidClassException, NoSuchMethodException, InvocationTargetException {
        Human animal = (Human) this.build();

        //TODO : Check if is human class
        animal.setInsertion(insertion);
        animal.setLastName(lastName);
        animal.setUsesBirthControl(usesBirthControl);
        return animal;
    }

}
