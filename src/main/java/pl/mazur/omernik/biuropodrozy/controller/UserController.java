package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import UserService;
import pl.mazur.omernik.biuropodrozy.model.User;


@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView register(@ModelAttribute User user) {
        userService.save(user);
        return new ModelAndView("login");
    }

}
