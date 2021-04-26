package kg.food.courier.service.base;

import kg.food.courier.entity.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T create(T dto);

    T update(T dto);

    void deleteById(Long id);

    List<T> findByAll();

    T findById(Long id);

}
