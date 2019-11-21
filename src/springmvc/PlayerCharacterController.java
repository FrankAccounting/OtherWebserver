package springmvc;

import hibernate.entity.PlayerCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PlayerCharacterService;

@Controller
@RequestMapping("/PlayerCharacter")
public class PlayerCharacterController {
    @Autowired
    private PlayerCharacterService playerCharacter;

}
