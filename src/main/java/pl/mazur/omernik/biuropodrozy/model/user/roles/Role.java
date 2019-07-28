package pl.mazur.omernik.biuropodrozy.model.user.roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.entity.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    private String roleName;
    //comment
}
