package bas.animalkingdom.controllers;

import bas.animalkingdom.animal.Animal;
import bas.animalkingdom.animal.gender.impl.Male;
import bas.animalkingdom.animal.impl.mammal.Human;
import bas.animalkingdom.animal.impl.mammal.elephant.AfricanElephant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnimalController {

    @RequestMapping(value = "/animals", method = RequestMethod.GET)
    public String getAnimals(ModelMap modelMap) {
        Animal animal = new AfricanElephant(new Male(), "Body Covering", "Ename", " acolor", 123, 321);
        modelMap.put("animal", animal);
        return "animals";
    }
}
