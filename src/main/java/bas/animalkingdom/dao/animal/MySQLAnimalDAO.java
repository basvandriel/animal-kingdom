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
import bas.animalkingdom.animal.impl.mammal.STD;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.AsianElephant;
import bas.animalkingdom.animal.impl.mammal.elephant.Elephant;
import bas.animalkingdom.animal.impl.mammal.mouse.GrayMouse;
import bas.animalkingdom.animal.impl.mammal.mouse.Mouse;
import bas.animalkingdom.animal.impl.mammal.mouse.WhiteMouse;
import bas.animalkingdom.animal.impl.reptile.Crocodile;
import bas.animalkingdom.animal.impl.reptile.Snake;
import bas.animalkingdom.animal.impl.special.Platypus;
import bas.animalkingdom.zoo.Zoo;

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
        Zoo.getInstance("ICO41A").getCages().clear();

        ArrayList<Animal> animals = new ArrayList<>();
        if (this.connection == null || this.connection.isClosed()) {
            return null;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("    SELECT \n" +
                    "        animal.`UUID`,\n" +
                    "        animalType.`name` AS 'animalType',\n" +
                    "        gender.`name` AS 'gender',\n" +
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

            ResultSet animalResult = preparedStatement.executeQuery();
            while (animalResult.next()) {
                String animalType = className.get(animalResult.getString(2));
                if (animalType == null || animalType.equals("")) {
                    return null;
                }
                String uuid = animalResult.getString(1);
                String gender = genderClasses.get(animalResult.getString(3));
                String bodyCovering = animalResult.getString(6);
                String name = animalResult.getString(4);
                String color = animalResult.getString(5);
                int weight = animalResult.getInt(7);
                int maxNumberOfEggs = animalResult.getInt(8);

                int animalPropertiesId = animalResult.getInt(9);

                Animal animal = null;
                AnimalFactory animalFactory = new AnimalFactory(animalType, gender, bodyCovering, name, color, weight, maxNumberOfEggs);
                if (Human.class.isAssignableFrom(Class.forName(animalType))) {
                    //Get human properties belonging to this animal
                    PreparedStatement humanPropertiesStatement = connection.prepareStatement("SELECT \n" +
                            "        humanAnimalProperties.`id`,\n" +
                            "        humanAnimalProperties.`insertion`,\n" +
                            "        humanAnimalProperties.`lastName`,\n" +
                            "        humanAnimalProperties.`usingBirthControl`,\n" +
                            "        humanAnimalProperties.`partner_UUID`,\n" +
                            "        humanAnimalProperties.`extraStdChance`,\n" +
                            "        humanAnimalProperties.`extraCaughtCheatingChance`\n" +
                            "        \n" +
                            "    FROM `human-animal-properties` AS humanAnimalProperties\n" +
                            "" +
                            "WHERE humanAnimalProperties.`animal-properties-id` = ?");
                    humanPropertiesStatement.setInt(1, animalPropertiesId);

                    //Execute the query
                    ResultSet humanPropertiesResult = humanPropertiesStatement.executeQuery();


                    if (humanPropertiesResult != null && humanPropertiesResult.next()) {
                        int humanAnimalPropertiesId = humanPropertiesResult.getInt(1);
                        String insertion = humanPropertiesResult.getString(2);
                        String lastName = humanPropertiesResult.getString(3);
                        boolean isUsingBirthControl = humanPropertiesResult.getByte(4) == 1;

                        animal = animalFactory.build(insertion, lastName, isUsingBirthControl);
                        //Set the extra STD chance
                        ((Human) animal).setExtraStdChance(humanPropertiesResult.getInt(6));

                        //Set the extra caught cheating chance
                        ((Human) animal).setExtraCaughtCheatingChance(humanPropertiesResult.getInt(7));

                        PreparedStatement humanSTDsStatement = connection.prepareStatement(
                                "SELECT\n" +
                                        "std.`name`" +
                                        "\n" +
                                        "    FROM `humanstds` AS humanstds" +
                                        "\n" +
                                        "    INNER JOIN `std` AS std" +
                                        "      ON humanstds.`std-id` = std.`id`" +
                                        "\n" +
                                        "        WHERE humanstds.`human-animal-property-id` = ?;");

                        humanSTDsStatement.setInt(1, humanAnimalPropertiesId);

                        ResultSet humanSTDs = humanSTDsStatement.executeQuery();

                        ArrayList<STD> currentHumanSTDs = new ArrayList<>();
                        while (humanSTDs.next()) {
                            STD std = new STD(humanSTDs.getString(1));
                            if (std == null) {
                                continue;
                            }
                            currentHumanSTDs.add(std);
                        }
                        ((Human) animal).setStds(currentHumanSTDs);
                    }
                } else if (Elephant.class.isAssignableFrom(Class.forName(animalType))) {
                    PreparedStatement elephantPropertiesStatement = connection.prepareStatement(
                            "SELECT \n" +
                                    "        elephantAnimalProperties.`earSize`" +
                                    "\n" +
                                    "    FROM `elephant-animal-properties` AS elephantAnimalProperties\n" +
                                    "" +
                                    "WHERE elephantAnimalProperties.`animal-properties-id` = ?");

                    elephantPropertiesStatement.setInt(1, animalPropertiesId);

                    ResultSet elephantPropertiesResult = elephantPropertiesStatement.executeQuery();

                    int earSize = 0;
                    if (elephantPropertiesResult.next()) {
                        earSize = elephantPropertiesResult.getInt(1);
                    }
                    animal = animalFactory.build(earSize);
                } else {
                    animal = animalFactory.build();
                }
                //TODO Set animal eggs

                if (animal == null) {
                    return null;
                }
                animal.setUuid(UUID.fromString(uuid));
                animals.add(animal);
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvalidClassException e) {
            e.printStackTrace();
        } finally {
            PreparedStatement getMarriedHumansStatement = connection.prepareStatement(
                    "SELECT \n" +
                            "animal.`UUID`,\n" +
                            "humanAnimalProperties.`partner_UUID`,\n" +
                            "partnerHumanAnimalProperties.`partner_UUID` AS partner_partner_UUID\n" +
                            "\n" +
                            "FROM `animal` AS animal\n" +
                            "\t\n" +
                            "INNER JOIN `animal-properties` AS animalProperties\n" +
                            "\tON animal.`animal-properties-id` = animalProperties.`id`\n" +
                            "\n" +
                            "INNER JOIN `human-animal-properties` AS humanAnimalProperties\n" +
                            "\tON animalProperties.`id` = humanAnimalProperties.`animal-properties-id`\n" +
                            "    \n" +
                            "INNER JOIN `animal` as partnerAnimal\n" +
                            "\tON humanAnimalProperties.`partner_UUID` = partnerAnimal.`UUID`\n" +
                            "    \n" +
                            "INNER JOIN `animal-properties` AS partnerAnimalProperties\n" +
                            "\tON partnerAnimal.`animal-properties-id` = partnerAnimalProperties.`id`\n" +
                            "    \n" +
                            "INNER JOIN `human-animal-properties` AS partnerHumanAnimalProperties\n" +
                            "\tON partnerAnimalProperties.`id`  = partnerHumanAnimalProperties.`animal-properties-id`");

            ResultSet marriedHumanData = getMarriedHumansStatement.executeQuery();
            while (marriedHumanData.next()) {
                String currentAnimalUUID = marriedHumanData.getString(1);
                String currentAnimalsPartnerUUID = marriedHumanData.getString(2);
                String currentAnimalsPartnersPartnersUUID = marriedHumanData.getString(3);

                Human currentAnimal = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(currentAnimalUUID));
                Human currentAnimalsPartner = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(currentAnimalsPartnerUUID));

                if (currentAnimal == null || currentAnimalsPartner == null || !currentAnimalUUID.equals(currentAnimalsPartnersPartnersUUID)) {
                    continue;
                }
                currentAnimal.setPartner(currentAnimalsPartner);
            }
        }
        return animals;
    }


    @Override
    public Animal read(String uuid) {
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
