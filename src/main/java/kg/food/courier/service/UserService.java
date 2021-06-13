package kg.food.courier.service;

import kg.food.courier.entity.User;
import kg.food.courier.model.OrganizationManagerDto;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User> {

    Page<User> findByUsernameWithSearch (Long orgId, Pageable pageable, String value);
    Page<User> findByOrganization_Id(Long orgId,Pageable pageable);

    String createOrganizationManager(OrganizationManagerDto organizationManagerDto);
    String updateOrganizationManager(OrganizationManagerDto organizationManagerDto);
}