package pl.mazur.omernik.biuropodrozy.trips;

import lombok.*;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private Integer stockAmount;
    private String countryOfPublishing;
    private String title;
    private String description;
    private String pictureURL;
    private BigDecimal price;
    private ProductType productType;
    private Long authorId;
    private Long categoryId;
    private String categoryName;


    public String getProductTypePl() {
        return Optional.ofNullable(productType).map(e -> e.getType()).orElse("");
    }
}
