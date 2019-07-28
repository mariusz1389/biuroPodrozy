package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<T> findByUsername(String userName);

    boolean existsByUsername(String userName);
}
