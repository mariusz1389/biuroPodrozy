package pl.mazur.omernik.biuropodrozy.model.user;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.model.user.roles.Role;
import pl.mazur.omernik.biuropodrozy.model.user.roles.RoleRepository;
import pl.mazur.omernik.biuropodrozy.model.user.roles.RoleTypeEnum;

import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository<Customer> userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(CustomerRegistrationDto customerRegistrationDto) {
        Customer user = UserRegistrationDtoToUserBuilder.rewriteToCustomer(customerRegistrationDto, passwordEncoder);
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserExistsException("User with username " + user.getUsername() + "already exists in database");
        } else {
            addUser(user);
        }
    }

    private void addUser(Customer user) {
        Role roleUser = Optional.ofNullable(roleRepository.findRoleByRoleName("ROLE_USER"))
                .orElseGet(() -> roleRepository.save(new Role(RoleTypeEnum.USER.getRoleName())));
        user.setRoles(Sets.newHashSet(roleUser));
        userRepository.save(user);
    }

}
