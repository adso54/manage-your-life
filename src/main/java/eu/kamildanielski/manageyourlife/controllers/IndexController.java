package eu.kamildanielski.manageyourlife.controllers;

import eu.kamildanielski.manageyourlife.services.ExpenditureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import eu.kamildanielski.manageyourlife.services.UserService;

@Controller
public class IndexController {



    private final ExpenditureService expenditureService;

    public IndexController(ExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("expenditures", expenditureService.getExpenditures());
        return "index";
    }
}
