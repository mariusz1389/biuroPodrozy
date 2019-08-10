package pl.mazur.omernik.biuropodrozy.model.user;

import lombok.*;
import org.hibernate.annotations.Cascade;
import pl.mazur.omernik.biuropodrozy.entity.BaseEntity;
import pl.mazur.omernik.biuropodrozy.model.user.roles.Role;


import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
public class User extends BaseEntity {

    private String firstName;
    private String surename;
    private String username;
    private String passwordHash;


    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "user_role")
    private Set<Role> roles;

    private UserAddress userAddress;
}
