/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Bas van Driel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package bas.animalkingdom.dao.animal;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.AnimalFactory;
import bas.animalkingdom.animal.gender.impl.Female;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.bird.Parrot;
import bas.animalkingdom.animal.impl.bird.Pinguin;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;
import bas.animalkingdom.animal.impl.mammal.mouse.GrayMouse;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import bas.animalkingdom.animal.impl.reptile.Snake;
import bas.animalkingdom.animal.impl.special.Platypus;

import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public class MySQLAnimalDAO implements AnimalDao {

    private Connection connection;

    private static Map<String, String> className = new HashMap<String, String>() {
        {
            put("Parrot", Parrot.class.getName());
            put("Pinguin", Pinguin.class.getName());
            put("Human", Human.class.getName());
            put("AfricanElephant", AfricanElephant.class.getName());
            put("AsianElephant", AsianElephant.class.getName());
            put("GrayMouse", GrayMouse.class.getName());
            put("WhiteMouse", WhiteMouse.class.getName());
            put("Crocodile", Crocodile.class.getName());
            put("Snake", Snake.class.getName());
            put("Platypus", Platypus.class.getName());
            put("Mouse", Mouse.class.getName());
        }
    };

    private static Map<String, String> genderClasses = new HashMap<String, String>() {
        {
            put("Male", Male.class.getName());
            put("Female", Female.class.getName());
        }
    };

    public MySQLAnimalDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Animal> readAll() throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        if (this.connection == null || this.connection.isClosed()) {
            return null;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("    SELECT \n" +
                    "        animal.`UUID`,\n" +
                    "        animalType.`name` AS 'animalType',\n" +
                    "       gender.`name` AS 'gender',\n" +
                    "        animalProperties.`name`,\n" +
                    "        animalProperties.`color`,\n" +
                    "        animalProperties.`bodyCovering`,\n" +
                    "        animalProperties.`weight`,\n" +
                    "        animalProperties.`maxNumberOfEggs`,\n" +
                    "        animalProperties.`id`\n" +
                    "" +
                    "    FROM `animal` AS animal\n" +
                    "\t\t\n" +
                    "\tINNER JOIN `animal-properties` AS animalProperties\n" +
                    "\t\tON animal.`animal-properties-id` = animalProperties.`id`\n" +
                    "        \n" +
                    "\tINNER JOIN `animal-type` AS animalType \n" +
                    "\t\tON animalProperties.`animal-type-id` = animalType.`id`\n" +
                    "\t\n" +
                    "\tINNER JOIN `gender` AS gender\n" +
                    "\t\tON animalProperties.`gender-id` = gender.`id`;");


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String animalType = className.get(resultSet.getString(2));
                if (animalType == null || animalType.equals("")) {
                    continue;
                }
                String uuid = resultSet.getString(1);
                String gender = genderClasses.get(resultSet.getString(3));

                String bodyCovering = resultSet.getString(6);
                String name = resultSet.getString(4);
                String color = resultSet.getString(5);
                int weight = resultSet.getInt(7);
                int maxNumberOfEggs = resultSet.getInt(8);

                int animalPropertiesId = resultSet.getInt(9);


                Animal animal = null;

                AnimalFactory animalFactory = new AnimalFactory(animalType, gender, bodyCovering, name, color, weight, maxNumberOfEggs);

                if (Human.class.isAssignableFrom(Class.forName(animalType))) {

                    PreparedStatement humanPropertiesQuery = connection.prepareStatement("    SELECT \n" +
                            "\t\thumanAnimalProperties.`insertion`,\n" +
                            "        humanAnimalProperties.`lastName`,\n" +
                            "        humanAnimalProperties.`usingBirthControl`,\n" +
                            "        humanAnimalProperties.`partner_UUID`,\n" +
                            "        humanAnimalProperties.`extraStdChance`,\n" +
                            "        humanAnimalProperties.`extraCaughtCheatingChance`\n" +
                            "        \n" +
                            "    FROM `human-animal-properties` AS humanAnimalProperties\n" +
                            "" +
                            "WHERE humanAnimalProperties.`animal-properties-id` = " + animalPropertiesId);

                    ResultSet humanPropertiesResult = humanPropertiesQuery.getResultSet();

                    if (humanPropertiesResult.next()) {
                        String insertion = humanPropertiesResult.getString(1);
                        String lastName = humanPropertiesResult.getString(2);
                        byte isUsingBirthControl = humanPropertiesResult.getByte(3);

                        UUID partnerUUID = UUID.fromString(humanPropertiesResult.getString(4));
                        int extraStdChance = humanPropertiesResult.getInt(5);
                        int extraCaughtCheatingChance = humanPropertiesResult.getInt(6);

                        animal = animalFactory.build(insertion, lastName, isUsingBirthControl == 1);
                    }

                    //TODO: Set humans partner
                    //TODO: Set extra std chance
                    //TODO: Set extraCaughtCheatingChance
                } else if (Elephant.class.isAssignableFrom(Class.forName(animalType).getClass())) {
                    animal = animalFactory.build();
                } else {
                    animal = animalFactory.build();
                }

                if (animal == null) {
                    continue;
                }
                animal.setUuid(UUID.fromString(uuid));
                animals.add(animal);
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvalidClassException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }

        return animals;
    }

    @Override
    public Animal read(UUID uuid) {
        return null;
    }

    @Override
    public Animal edit() {
        return null;
    }

    @Override
    public Animal add() {
        return null;
    }
}
