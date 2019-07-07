package pl.mazur.omernik.biuropodrozy.categories;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    private Long id;
    private Long parentId;
    private Integer depth;
    private String name;
    private CategoryDTO parentCat;
    private CategoryState state;

    public String getText() {
        return id + ". " + name;
    }

    public String getParent() {
        return parentId == null ? "#" : parentId.toString();
    }
}
