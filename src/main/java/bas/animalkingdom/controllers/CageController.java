package bas.animalkingdom.controllers;

import bas.animalkingdom.zoo.Cage;
import bas.animalkingdom.zoo.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by Bas on 4-12-2016.
 */
@Controller("Cage")
public class CageController {

    @RequestMapping(value = "/cages", method = RequestMethod.GET)
    public String getAnimals(ModelMap modelMap) {
        Zoo zoo = Zoo.getInstance("ICO41A");

        if (zoo.getCages().size() != 0) {
            modelMap.put("cages", zoo.getCages());
        }
        return "cage-overview";
    }
}
