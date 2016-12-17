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
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import javax.xml.transform.Result;
import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
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
                            "INNER JOIN `animal` AS partnerAnimal\n" +
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

                //If partner is itself or partner is not the partners partner then continue
                if (currentAnimalUUID.equals(currentAnimalsPartnerUUID) || !currentAnimalUUID.equals(currentAnimalsPartnersPartnersUUID)) {
                    continue;
                }

                Human currentAnimal = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(currentAnimalUUID));
                Human currentAnimalsPartner = (Human) Zoo.getInstance("ICO41A").getAnimalByUUID(UUID.fromString(currentAnimalsPartnerUUID));

                if (currentAnimal == null || currentAnimalsPartner == null) {
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
    public void update(Animal animal) {
        try {
            if (animal == null || this.connection == null || this.connection.isClosed()) {
                return;
            }
            PreparedStatement getAnimalPropertiesIdStatement = connection.prepareStatement(
                    "SELECT animal.`animal-properties-id`\n" +
                            "  FROM `animal` AS animal\n" +
                            "\n" +
                            "  WHERE animal.`UUID` = ?;");
            getAnimalPropertiesIdStatement.setString(1, animal.getUuid().toString());
            ResultSet getAnimalPropertiesIdResult = getAnimalPropertiesIdStatement.executeQuery();

            if (!getAnimalPropertiesIdResult.next()) {
                return;
            }
            int animalPropertiesId = getAnimalPropertiesIdResult.getInt(1);

            //Update normal properties
            PreparedStatement updateStandardVariablesStatement = connection.prepareStatement(
                    "UPDATE `animal` AS animal\n" +
                            "  INNER JOIN `animal-properties` AS animalProperties\n" +
                            "    ON animal.`animal-properties-id` = animalProperties.`id`\n" +
                            "\n" +
                            "  SET animalProperties.`gender-id` = ?,\n" +
                            "      animalProperties.`bodyCovering` = ?,\n" +
                            "      animalProperties.`name` = ?,\n" +
                            "      animalProperties.`color` = ?, \n" +
                            "      animalProperties.`weight` = ?, \n" +
                            "      animalProperties.`maxNumberOfEggs` = ?\n" +
                            "\n" +
                            "  WHERE animal.`UUID` = ?;"
            );

            //Set the animal gender (refactor if there are more genders)
            updateStandardVariablesStatement.setInt(1, animal.isFemale() ? 2 : 1);

            //Set the animals body covering
            updateStandardVariablesStatement.setString(2, animal.getBodyCovering());

            //Set the animals name
            updateStandardVariablesStatement.setString(3, animal.getName());

            //Set the animals color
            updateStandardVariablesStatement.setString(4, animal.getColor());

            //Set the animals weight
            updateStandardVariablesStatement.setInt(5, animal.getWeight());

            //Set the animals eggs
            updateStandardVariablesStatement.setInt(6, animal.getMaxNumberOfEggs());

            //Set the UUID parameter
            updateStandardVariablesStatement.setString(7, animal.getUuid().toString());

            //Execute the update
            updateStandardVariablesStatement.executeUpdate();

            //If the animal is a human
            if (Human.class.isAssignableFrom(animal.getClass())) {
                PreparedStatement updateHumanVariablesStatement = connection.prepareStatement(
                        "UPDATE `human-animal-properties`\n" +
                                "  SET\n" +
                                "      `insertion` = ?,\n" +
                                "      `lastName` = ?,\n" +
                                "      `usingBirthControl` = ?,\n" +
                                "      `partner_UUID` = ?,\n" +
                                "      `extraStdChance` = ?,\n" +
                                "      `extraCaughtCheatingChance` = ?\n" +
                                "\n" +
                                "  WHERE `animal-properties-id` = ?;"
                );

                //Set the humans insertion
                updateHumanVariablesStatement.setString(1, ((Human) animal).getInsertion());

                //Set the humans last name
                updateHumanVariablesStatement.setString(2, ((Human) animal).getLastName());

                //Set the humans insertion
                byte isUsingBirthControl = (byte) (((Human) animal).isUsingBirthControl() ? 1 : 0);
                updateHumanVariablesStatement.setByte(3, isUsingBirthControl);

                //Set the humans partner
                updateHumanVariablesStatement.setNull(4, Types.VARCHAR);
                if (((Human) animal).getPartner() != null) {
                    updateHumanVariablesStatement.setString(4, ((Human) animal).getPartner().getUuid().toString());
                }

                //Set the humans extra STD chance
                updateHumanVariablesStatement.setInt(5, (int) ((Human) animal).getExtraStdChance());

                //Set the humans extra chance caught of cheating chance
                updateHumanVariablesStatement.setInt(6, (int) ((Human) animal).getExtraCaughtCheatingChance());

                //Set the human animal properties id
                updateHumanVariablesStatement.setInt(7, animalPropertiesId);

                updateHumanVariablesStatement.executeUpdate();

                //Get human animal property id
                PreparedStatement getHumanAnimalPropertyIDStatement = connection.prepareStatement(
                        "SELECT humanAnimalProperties.`id`\n" +
                                "\n" +
                                "  FROM `human-animal-properties` AS humanAnimalProperties\n" +
                                "\n" +
                                "  WHERE humanAnimalProperties.`animal-properties-id` = ?\n" +
                                "\n" +
                                "  LIMIT 1;"
                );
                getHumanAnimalPropertyIDStatement.setInt(1, animalPropertiesId);
                ResultSet getHumanAnimalPropertiesIdResult = getHumanAnimalPropertyIDStatement.executeQuery();

                if (getHumanAnimalPropertiesIdResult.next()) {
                    int humanAnimalPropertyID = getHumanAnimalPropertiesIdResult.getInt(1);
                    //Set the human stds
                    ArrayList<STD> humanSTDs = ((Human) animal).getSTDs();


                    PreparedStatement deleteHumanSTDsStatement = connection.prepareStatement(
                            "DELETE FROM `humanstds`\n" +
                                    "  WHERE `human-animal-property-id` = ?;"
                    );
                    deleteHumanSTDsStatement.setInt(1, humanAnimalPropertyID);
                    deleteHumanSTDsStatement.executeUpdate();

                    for (STD std : humanSTDs) {
                        PreparedStatement getSTDidByNameStatement = connection.prepareStatement(
                                "SELECT \n" +
                                        "  std.`id`\n" +
                                        "  \n" +
                                        "  FROM `std` AS std   \n" +
                                        "  \n" +
                                        "  WHERE std.name = ?\n" +
                                        "\n" +
                                        "  LIMIT 1;"
                        );
                        getSTDidByNameStatement.setString(1, std.getName());
                        ResultSet getSTDidByName = getSTDidByNameStatement.executeQuery();

                        if (!getSTDidByName.next()) {
                            PreparedStatement insertSTDStatement = connection.prepareStatement(
                                    "INSERT INTO `std`\n" +
                                            "(`id`, `name`)\n" +
                                            "\n" +
                                            "VALUES (NULL, ?);"
                            );
                            insertSTDStatement.setString(1, std.getName());
                            insertSTDStatement.executeUpdate();
                        }
                        getSTDidByName = getSTDidByNameStatement.executeQuery();
                        int stdId = getSTDidByName.getInt(1);

                        PreparedStatement insertHumanSTDStatement = connection.prepareStatement(
                                "INSERT INTO `humanstds`\n" +
                                        "(`id`, `human-animal-property-id`, `std-id`)\n" +
                                        "\n" +
                                        "\n" +
                                        "VALUES (NULL, ?, ?);"
                        );
                        insertHumanSTDStatement.setInt(1, animalPropertiesId);
                        insertHumanSTDStatement.setInt(2, stdId);

                        insertHumanSTDStatement.executeUpdate();
                    }
                }

            } else if (Elephant.class.isAssignableFrom(animal.getClass())) {
                PreparedStatement updateElephantVariablesStatement = connection.prepareStatement(
                        "UPDATE `elephant-animal-properties` AS elephantAnimalProperties\n" +
                                "  SET\n" +
                                "      elephantAnimalProperties.earsize = ?\n" +
                                "\n" +
                                "  WHERE elephantAnimalProperties.`animal-properties-id` = ?;"
                );
                updateElephantVariablesStatement.executeUpdate();
            }
            //TODO Set the animal eggs

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Animal animal) {
        try {
            if (animal == null || this.connection == null || this.connection.isClosed()) {
                return;
            }

            //Get the animal type id
            PreparedStatement getAnimalTypeIDStatement = connection.prepareStatement(
                    "SELECT \n" +
                            "  animalType.`id` \n" +
                            "\n" +
                            "  FROM `animal-type` AS animalType\n" +
                            "  \n" +
                            "  WHERE animalType.name = ?\n" +
                            "\n" +
                            "  LIMIT 1;"
            );

            getAnimalTypeIDStatement.setString(1, animal.getClass().getSimpleName());
            ResultSet getAnimalTypeIDResult = getAnimalTypeIDStatement.executeQuery();
            if (!getAnimalTypeIDResult.next()) {
                return;
            }
            int animalTypeID = getAnimalTypeIDResult.getInt(1);

            //Insert the generic animal properties
            PreparedStatement insertGenericAnimalPropertiesStatement = connection.prepareStatement(
                    "INSERT INTO `animal-properties`\n" +
                            "(`id`, `animal-type-id`, `gender-id`, `name`, `bodyCovering`, `color`,  `weight`, `maxNumberOfEggs`)\n" +
                            "    \n" +
                            "    VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);"
            );

            insertGenericAnimalPropertiesStatement.setInt(1, animalTypeID);

            //Set the gender ID
            insertGenericAnimalPropertiesStatement.setInt(2, animal.isFemale() ? 2 : 1);

            //Set the animal name
            insertGenericAnimalPropertiesStatement.setString(3, animal.getName());

            //Set the animals body covering
            insertGenericAnimalPropertiesStatement.setString(4, animal.getBodyCovering());

            //Set the animals color
            insertGenericAnimalPropertiesStatement.setString(5, animal.getColor());

            //Set the animals weight
            insertGenericAnimalPropertiesStatement.setInt(6, animal.getWeight());

            //Set the animals max number of eggs
            insertGenericAnimalPropertiesStatement.setInt(7, animal.getMaxNumberOfEggs());

            //Execute the query
            insertGenericAnimalPropertiesStatement.executeUpdate();

            //Get the animal properties id
            ResultSet insertGenericAnimalPropertiesStatementKeys = insertGenericAnimalPropertiesStatement.getGeneratedKeys();
            if (!insertGenericAnimalPropertiesStatementKeys.next()) {
                return;
            }
            int animalPropertiesID = insertGenericAnimalPropertiesStatementKeys.getInt(1);

            //If the animal is a type of human
            if (Human.class.isAssignableFrom(animal.getClass())) {
                //Insert the standard human animal properties
                PreparedStatement insertHumanPropertiesStatement = connection.prepareStatement(
                        "INSERT INTO `human-animal-properties`\n" +
                                "    (`id`, `animal-properties-id`, `insertion`, `lastName`, `usingBirthControl`, `partner_UUID`, `extraStdChance`, `extraCaughtCheatingChance`)\n" +
                                "    \n" +
                                "    VALUES(NULL, ?, ?, ?, ?, NULL, 0, 0);"
                );
                //Set the human animal properties id
                insertHumanPropertiesStatement.setInt(1, animalPropertiesID);

                //Set the human animal insertion
                insertHumanPropertiesStatement.setString(2, ((Human) animal).getInsertion());

                //Set the human animals last name
                insertHumanPropertiesStatement.setString(3, ((Human) animal).getLastName());

                //Set if the human animal is using birth control
                insertHumanPropertiesStatement.setInt(4, ((Human) animal).isUsingBirthControl() ? 1 : 0);

                //Execute the query
                insertHumanPropertiesStatement.executeUpdate();
            } else if (Elephant.class.isAssignableFrom(animal.getClass())) {
                //Insert the elephant animal properties
                PreparedStatement insertElephantropertiesStatement = connection.prepareStatement(
                        "INSERT INTO `elephant-animal-properties`\n" +
                                "    (`id`, `animal-properties-id`, `earsize`)\n" +
                                "    \n" +
                                "    VALUES(NULL, ?, ?);"
                );
                //Set the human animal properties id
                insertElephantropertiesStatement.setInt(1, animalPropertiesID);

                //Set the human animal insertion
                insertElephantropertiesStatement.setInt(2, ((Elephant) animal).getEarSize());

                //Execute the query
                insertElephantropertiesStatement.executeUpdate();
            }

            //Insert the animal itself
            PreparedStatement insertAnimalStatement = connection.prepareStatement(
                    "INSERT INTO `animal`\n" +
                            "  (UUID, `animal-properties-id`)\n" +
                            "    \n" +
                            "  VALUES (?, ?);"
            );
            insertAnimalStatement.setString(1, animal.getUuid().toString());
            insertAnimalStatement.setInt(2, animalPropertiesID);
            insertAnimalStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
