package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.mazur.omernik.biuropodrozy.model.user.CustomerRegistrationDto;
import pl.mazur.omernik.biuropodrozy.model.user.UserExistsException;
import pl.mazur.omernik.biuropodrozy.model.user.UserRegistrationService;
import pl.mazur.omernik.biuropodrozy.weather.service.WeatherService;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HI";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("customerFormData", new CustomerRegistrationDto());

        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String registerEffect(@ModelAttribute(name = "customerFormData")
                                 @Valid CustomerRegistrationDto customerFormData,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        try {
            userRegistrationService.registerUser(customerFormData);
        } catch (UserExistsException e) {
            model.addAttribute("userExistsException", e.getMessage());
            return "registerForm";
        }
        model.addAttribute("registrationData", customerFormData);
        return "registerEffect";
    }

    @GetMapping("/weather")
    @ResponseBody
    public ResponseEntity<String> weather() {
        try {
            String weather = weatherService.getWeather();
            return ResponseEntity.ok(weather);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Błąd");
        }
    }


}


