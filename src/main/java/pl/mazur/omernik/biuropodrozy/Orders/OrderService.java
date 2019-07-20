package pl.mazur.omernik.biuropodrozy.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.UserContextService;
import pl.mazur.omernik.biuropodrozy.cart.Cart;
import pl.mazur.omernik.biuropodrozy.cart.CartService;
import pl.mazur.omernik.biuropodrozy.model.user.Customer;
import pl.mazur.omernik.biuropodrozy.model.user.UserRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.TripRepository;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private UserContextService userContextService;

    @Autowired
    private OrderRepository ordersRepository;

    @Autowired
    private UserRepository<Customer> usersRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private TripRepository tripRepository;

    public Order placeOrder() {
        Cart cart = userContextService.getCart();
        String loggedUserEmail = userContextService.getLoggedUserEmail();
        Customer customer = usersRepository.findByUsername(loggedUserEmail).get();

        cart.getOrderLines()
                .stream()
                .peek(p -> p.getTrip().setStockAmount(p.getTrip().getStockAmount() - p.getQuantity()))
                .map(e->e.getTrip()).forEach(tripRepository::save);

        Order order = ordersRepository.save(new Order(customer.getUsername(), cartService.calculateTotalCartPrice(cart), customer.getUserAdress()
                , customer.getUserAdress(), LocalDateTime.now(), cart.getOrderLines(), customer, OrderStatus.NEW));
        userContextService.clearCart();
        return order;
    }

}
