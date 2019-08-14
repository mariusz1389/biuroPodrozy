package pl.mazur.omernik.biuropodrozy.cart;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    public BigDecimal calculateTotalCartPrice(Cart cart) {
        BigDecimal tripPrice = cart.getOrderLines()
                .stream()
                .map(e -> e.getTripPrice()
                        .multiply(BigDecimal.valueOf(e.getQuantity()))).reduce((a, b) -> a.add(b))
                .orElse(BigDecimal.ZERO);
        return tripPrice;
    }


}
