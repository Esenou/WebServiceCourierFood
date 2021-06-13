package kg.food.courier.service;

import kg.food.courier.entity.Organization;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationService extends BaseService<Organization> {

    Page<Organization> findByOrganizationNameWithSearch(Pageable pageable, String value);

    Page<Organization> getAllByPageable(Pageable pageable);
}
