package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    void save(User user);
    Optional<User> findByLogin(String login);
}