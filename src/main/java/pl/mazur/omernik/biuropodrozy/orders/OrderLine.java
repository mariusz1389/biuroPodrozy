package pl.mazur.omernik.biuropodrozy.orders;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.mazur.omernik.biuropodrozy.entity.BaseEntity;
import pl.mazur.omernik.biuropodrozy.model.Trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@ToString
@Table(name = "oreder_lines")
public class OrderLine extends BaseEntity implements Serializable {

    @OneToOne
    private Trip trip;

    private Integer quantity;

    @Column(name = "trip_price")
    private BigDecimal tripPrice;
}
