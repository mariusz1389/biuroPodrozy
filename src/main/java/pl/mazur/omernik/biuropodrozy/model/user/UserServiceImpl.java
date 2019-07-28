package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        repository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return repository.findByUsername(login);
    }
}
