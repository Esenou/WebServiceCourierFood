package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.Basket;
import kg.food.courier.service.BasketService;
import kg.food.courier.service.base.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basket")
public class BasketController extends BaseController<Basket,BasketService> {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        super(basketService);
        this.basketService = basketService;
    }
}
