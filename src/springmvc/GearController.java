package springmvc;

import hibernate.entity.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.GearService;
import service.GearServiceImpl;
import service.PlayerCharacterService;

import java.util.List;

@Controller
@RequestMapping("/gear")
public class GearController{
    @Autowired
    private GearService gearService;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Gear> gearList = gearService.listGear();

        theModel.addAttribute("gearList",gearList);

        return "list-gear";
    }

    @RequestMapping("/showAddGearForm")
    public String showAddGearForm(Model theModel){
        Gear newGear = new Gear();

        theModel.addAttribute("aGear",newGear);
        return "add-gear-form";


    }




}
