package kg.food.courier.service.impl;

import kg.food.courier.entity.Basket;
import kg.food.courier.repository.BasketRepository;
import kg.food.courier.service.BasketService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl extends BaseServiceImpl<Basket, BasketRepository> implements BasketService {
    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        super(basketRepository);
        this.basketRepository = basketRepository;
    }
}
