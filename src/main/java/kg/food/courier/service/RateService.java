package kg.food.courier.service;

import kg.food.courier.entity.Rate;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RateService extends BaseService<Rate> {
    Page<Rate> findByOrganization_IdAndProductLike(Long orgId, String value,Pageable pageable);
    Page<Rate> findAllByOrganization_Id(Long id, Pageable pageable);
}
