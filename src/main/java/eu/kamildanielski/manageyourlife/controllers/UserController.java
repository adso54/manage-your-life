package eu.kamildanielski.manageyourlife.controllers;

import eu.kamildanielski.manageyourlife.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user/show/{id}")
    public String showById(@PathVariable Long id, Model model){

        model.addAttribute("user", userService.getUserById(new Long(id)));

        return "user/show";
    }

}
