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
import com.mysql.jdbc.Connection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 */
@Repository("AnimalDAO")
public class MySQLAnimalDAO implements AnimalDao {

    private Connection connection;

    public MySQLAnimalDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Animal> readAll() throws SQLException {
        ArrayList<Animal> animals = null;
        if (this.connection == null) {
            return null;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("    SELECT \n" +
                    "        animal.`UUID`,\n" +
                    "        animalType.`name` AS 'animalType',\n" +
                    "        gender.`name` AS 'gender',\n" +
                    "        animalProperties.`name`,\n" +
                    "        animalProperties.`bodyCovering`,\n" +
                    "        animalProperties.`weight`,\n" +
                    "        animalProperties.`maxNumberOfEggs`\n" +
                    "        \n" +
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

            preparedStatement.execute();


        } catch (SQLException exception) {

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
