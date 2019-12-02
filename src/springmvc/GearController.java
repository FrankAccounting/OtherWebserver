package springmvc;

import hibernate.entity.Gear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.GearService;
import service.GearServiceImpl;
import service.PlayerCharacterService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/gear")
public class GearController {
    @Autowired
    private GearService gearService;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Gear> gearList = gearService.listGear();

        theModel.addAttribute("gearList", gearList);

        return "list-gear";
    }

    @RequestMapping("/showAddGearForm")
    public String showAddGearForm(Model theModel) {
        Gear newGear = new Gear();

        theModel.addAttribute("aGear", newGear);
        return "add-gear-form";
    }

    @RequestMapping("/save")
    public String createGear(
            @Valid @ModelAttribute("gear") Gear newGear,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-gear-form";
        }
        gearService.createGear(newGear);
        return "redirect:/gear/list";
    }

    @RequestMapping("/showUpdateGearForm")
    public String showUpdategearForm(@RequestParam("gearId") int theId, Model theModel) {
        Gear theGear = gearService.getGear(theId);
        theModel.addAttribute("aGear", theGear);
        return "add-gear-form";
    }

    @RequestMapping("/delete")
    public String deleteGear(
            @RequestParam("gearId") int theId){
        gearService.deleteGear(theId);
        return "redirect:/gear/list";
    }

    @GetMapping("/search")
    public  String search(@RequestParam("searchTerm")
                          String theSearchTerm, Model theModel){
        List<Gear> list = gearService.getGearByName(theSearchTerm);
        theModel.addAttribute("gearList",list);
        return "list-gear";

    }



}
