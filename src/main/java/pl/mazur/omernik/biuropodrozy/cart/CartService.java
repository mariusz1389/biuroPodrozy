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
        return tripPrice.add(calculateDelivery(tripPrice));
    }

    public BigDecimal calculateDelivery(BigDecimal tripPrice) {
        if (tripPrice.compareTo(BigDecimal.valueOf(200.0)) > 0) {
            return BigDecimal.ZERO;
        }
        if (tripPrice.compareTo(BigDecimal.valueOf(100.0)) > 0) {
            return BigDecimal.ONE;
        }
        return BigDecimal.TEN;
    }

}
