package pl.mazur.omernik.biuropodrozy.model.user.roles;

import lombok.Getter;

@Getter
public enum RoleTypeEnum {

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String roleName;

    RoleTypeEnum(String roleName){
        this.roleName = roleName;
    }
}
