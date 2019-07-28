package pl.mazur.omernik.biuropodrozy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mazur.omernik.biuropodrozy.orders.OrderService;

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
