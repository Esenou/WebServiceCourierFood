package kg.food.courier.service;

import kg.food.courier.entity.Client;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService extends BaseService<Client> {

    Page<Client> findByUsernameWithSearch (Pageable pageable, String value);
    Page<Client> getAllByPageable(Pageable pageable);

}
