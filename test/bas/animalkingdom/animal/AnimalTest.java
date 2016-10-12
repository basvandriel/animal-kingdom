package bas.animalkingdom.animal;

import bas.animalkingdom.animal.gender.Gender;
import bas.animalkingdom.animal.gender.impl.Male;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AnimalTest {

    private Animal animal;

    private Gender gender = new Male();

    private String bodyCovering = "No body covering";
    private String name = "Bas";
    private String color = "Green and red";
    private int weight = 1234;
    private int maxNumbersOfEggs = 1234;

    @Before
    public void setUp() {
        this.animal = new Animal(this.gender, this.bodyCovering, this.name, this.color, this.weight, this.maxNumbersOfEggs) {

            @Override
            public String communicate() {
                return "Je kan geen moer";
            }
        };
    }

    @Test
    public void communicate() throws Exception {
        String expected = "Je kan geen moer";

        String output = this.animal.communicate();

        assertEquals(expected, output);
    }

    @Test
    public void propagate() throws Exception {

    }

    @Test
    public void isPregnant() throws Exception {

    }

    @Test
    public void giveBirth() throws Exception {

    }

    @Test
    public void isFemale() throws Exception {

    }

    @Test
    public void setGender() throws Exception {

    }

    @Test
    public void setBodyCovering() throws Exception {

    }

    @Test
    public void setName() throws Exception {

    }

    @Test
    public void setColor() throws Exception {

    }

    @Test
    public void setWeight() throws Exception {

    }

    @Test
    public void setMaxNumberOfEggs() throws Exception {

    }

    @Test
    public void getGender() throws Exception {

    }

    @Test
    public void getBodyCovering() throws Exception {

    }

    @Test
    public void getName() throws Exception {

    }

    @Test
    public void getColor() throws Exception {

    }

    @Test
    public void getWeight() throws Exception {

    }

    @Test
    public void getMaxNumberOfEggs() throws Exception {

    }

}