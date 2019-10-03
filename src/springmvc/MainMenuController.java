package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainMenuController {
    @RequestMapping("showForm")
    public String showForm() {
        return "index";
    }


}
