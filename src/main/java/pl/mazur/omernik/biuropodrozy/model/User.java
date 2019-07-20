package pl.mazur.omernik.biuropodrozy.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import pl.mazur.omernik.biuropodrozy.Entity.BaseEntity;
import pl.mazur.omernik.biuropodrozy.model.roles.Role;
import pl.mazur.omernik.biuropodrozy.model.user.UserAdress;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@Entity
public class User extends BaseEntity {

    private String firstName;
    private String surename;
    private String username;
    private String passwordHash;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "user_role")
    private Set<Role> roles;

    private UserAdress userAdress;
}
