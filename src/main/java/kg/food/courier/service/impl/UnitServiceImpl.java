package kg.food.courier.service.impl;

import kg.food.courier.entity.Unit;
import kg.food.courier.repository.UnitRepository;
import kg.food.courier.service.UnitService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends BaseServiceImpl<Unit, UnitRepository> implements UnitService {

    private final UnitRepository unitRepository;
    public UnitServiceImpl(UnitRepository unitRepository) {
        super(unitRepository);
        this.unitRepository = unitRepository;
    }

    @Override
    public Page<Unit> getAllByPageable(Pageable pageable) {
        return unitRepository.getAllByPageable(pageable);
    }
}
