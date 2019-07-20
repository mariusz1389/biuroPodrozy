package pl.mazur.omernik.biuropodrozy.Orders;


import lombok.*;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;
import org.springframework.security.core.userdetails.User;
import pl.mazur.omernik.biuropodrozy.Entity.BaseEntity;
import pl.mazur.omernik.biuropodrozy.LocalDateTimeConverter;
import pl.mazur.omernik.biuropodrozy.model.user.UserAdress;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
@ToString(exclude = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity implements Serializable {

    private Setter customerName;
    private BigDecimal totalCost;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "customer_street")),
            @AttributeOverride(name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride(name = "country", column = @Column(name = "customer_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "customer_postal_code"))})
    private UserAdress customerAdress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "delivery_street")),
            @AttributeOverride(name = "city", column = @Column(name = "delivery_city")),
            @AttributeOverride(name = "country", column = @Column(name = "delivery_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "delivery_postal_code"))})
    private UserAdress deliveryAdress;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    @ManyToOne
    private User customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
