package pl.mazur.omernik.biuropodrozy.categories;

import lombok.*;
import pl.sda.shop.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity  {

    private Long parentId;
    private Integer depth;
    private String name;

    public Category(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }
}
