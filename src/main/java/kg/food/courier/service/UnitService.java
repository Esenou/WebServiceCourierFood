package kg.food.courier.service;

import kg.food.courier.entity.Unit;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService extends BaseService<Unit> {
    Page<Unit> getAllByPageable(Pageable pageable);
}
