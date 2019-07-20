package pl.mazur.omernik.biuropodrozy.cart;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import pl.mazur.omernik.biuropodrozy.Orders.OrderLine;

import java.util.List;

@Getter
@Setter
public class Cart {

    private List<OrderLine> orderLines = Lists.newArrayList();

}
