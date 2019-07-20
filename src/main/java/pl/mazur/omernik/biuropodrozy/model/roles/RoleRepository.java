package pl.mazur.omernik.biuropodrozy.model.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role findRoleByRoleName(String roleName);
    //comment
}
