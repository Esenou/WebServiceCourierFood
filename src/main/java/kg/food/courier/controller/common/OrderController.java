package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.Order;
import kg.food.courier.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController extends BaseController<Order, OrderService> {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }
}
