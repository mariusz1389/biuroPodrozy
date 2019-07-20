package pl.mazur.omernik.biuropodrozy.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/placeOrder")
    public String makeAnOrder(Model model){
        model.addAttribute("order", orderService.placeOrder());
        return  "orderFinisched";
    }
}
