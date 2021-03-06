package kg.food.courier.service;

import kg.food.courier.entity.User;
import kg.food.courier.model.ClientShortModel;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService  extends BaseService<User> {

    Page<User> findByUsernameWithSearch (Pageable pageable, String value);
    Page<User> getAllByPageable(Pageable pageable);

}
