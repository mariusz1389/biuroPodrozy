package pl.mazur.omernik.biuropodrozy.model;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class LoginUser extends User {
    public LoginUser(pl.mazur.omernik.biuropodrozy.model.User user) {
        super(user.getUsername(), user.getPasswordHash(), Collections.emptyList());
    }

}
