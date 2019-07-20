package pl.mazur.omernik.biuropodrozy.reposityory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mazur.omernik.biuropodrozy.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}

