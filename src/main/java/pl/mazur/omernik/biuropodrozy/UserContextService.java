package pl.mazur.omernik.biuropodrozy;

import com.google.gson.Gson;
import lombok.Getter;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.mazur.omernik.biuropodrozy.orders.OrderLine;
import pl.mazur.omernik.biuropodrozy.cart.Cart;
import pl.mazur.omernik.biuropodrozy.tripHandling.Trip;
import pl.mazur.omernik.biuropodrozy.model.user.roles.RoleTypeEnum;


import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class UserContextService {

    @Getter
    private Cart cart = new Cart();

    private static Gson gson = new Gson();

    public String getLoggedUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return authentication.getName();
    }


    public boolean admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.ADMIN.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }

    public boolean user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.USER.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }

    public String getCartAsJson() {
        return gson.toJson(cart);
    }


    public void addProductToCart(Trip trip) {
        List<OrderLine> orderLines = cart.getOrderLines();
        Optional<OrderLine> first = orderLines.stream().filter(e -> e.getTrip().getId().equals(trip.getId())).findFirst();
        if (first.isPresent()) {
            first.get().setQuantity(first.get().getQuantity() + 1);
        } else {
            OrderLine orderLine = new OrderLine();
            orderLine.setTrip(trip);
            orderLine.setTripPrice(trip.getPrice());
            orderLine.setQuantity(1);
            orderLines.add(orderLine);
        }
    }

    public void getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.USER.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            System.out.println();
        }
    }

    public void clearCart() {
        cart = new Cart();
    }

}
