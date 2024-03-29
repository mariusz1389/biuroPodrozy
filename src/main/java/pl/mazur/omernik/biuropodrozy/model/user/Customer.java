package pl.mazur.omernik.biuropodrozy.model.user;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.orders.Order;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("C")
public class Customer extends User {

    boolean preferEmails;
    boolean existByUsername;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> ordersList = Lists.newArrayList();

}
