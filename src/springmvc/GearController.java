package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.GearService;

@Controller
@RequestMapping("/gear")
public class GearController{
    @Autowired
    private GearService gearService;



}
