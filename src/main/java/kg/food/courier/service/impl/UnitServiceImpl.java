package kg.food.courier.service.impl;

import kg.food.courier.entity.Unit;
import kg.food.courier.repository.UnitRepository;
import kg.food.courier.service.UnitService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends BaseServiceImpl<Unit, UnitRepository> implements UnitService {
    public UnitServiceImpl(UnitRepository userRepository) {
        super(userRepository);
    }
}
