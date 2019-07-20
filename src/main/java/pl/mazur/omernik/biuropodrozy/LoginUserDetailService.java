package pl.mazur.omernik.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.LoginUser;
import pl.mazur.omernik.biuropodrozy.model.User;
import pl.mazur.omernik.biuropodrozy.reposityory.UserRepository;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws
            UsernameNotFoundException {
        Optional<User> user = repository.findByLogin(login);
        if (user.isPresent()) {
            return new LoginUser(user.get());
        }
        throw new UsernameNotFoundException(login);
    }
}