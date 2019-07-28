package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.model.user.CustomerRegistrationDto;
import pl.mazur.omernik.biuropodrozy.model.user.UserExistsException;
import pl.mazur.omernik.biuropodrozy.model.user.UserRegistrationService;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }



    @GetMapping(value = "/register")
    public ModelAndView registerForm(Model model) {
        model.addAttribute("customerFormData", new CustomerRegistrationDto());
        ModelAndView modelAndView = new ModelAndView("registerForm");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView registerEffect(@ModelAttribute(name = "customerFormData")
                                 @Valid CustomerRegistrationDto customerFormData,
                                 BindingResult bindingResult,
                                 Model model) {
        ModelAndView modelAndView = new ModelAndView("registerForm");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        try {
            userRegistrationService.registerUser(customerFormData);
        } catch (UserExistsException e) {
            model.addAttribute("userExistsException", e.getMessage());
            return modelAndView;
        }
        model.addAttribute("registrationData", customerFormData);
        return new ModelAndView("registerEffect");
    }


}


