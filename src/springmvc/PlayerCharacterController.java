package springmvc;

import hibernate.entity.PlayerCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PlayerCharacterService;

import java.util.List;

@Controller
@RequestMapping("/PlayerCharacter")
public class PlayerCharacterController {
    @Autowired
    private PlayerCharacterService playerCharacterService;

    @RequestMapping("/list")
    public String listPlayers(Model theModel){
        List<PlayerCharacter> playerList = playerCharacterService.listPlayers();

        theModel.addAttribute("playerList",playerList);
        return  "list-character";

    }

}
