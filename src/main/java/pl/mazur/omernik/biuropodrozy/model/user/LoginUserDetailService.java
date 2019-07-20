package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.LoginUser;
import pl.mazur.omernik.biuropodrozy.model.User;

import java.util.Optional;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws
            UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(userName);
        if (user.isPresent()) {
            return new LoginUser(user.get());
        }
        throw new UsernameNotFoundException(userName);
    }
}