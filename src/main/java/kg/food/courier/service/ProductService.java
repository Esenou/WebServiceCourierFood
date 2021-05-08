package kg.food.courier.service;

import kg.food.courier.entity.Product;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService extends BaseService<Product> {

    Page<Product> findByUsernameWithSearch(Pageable pageable, String value);

    Page<Product> getAllByPageable(Pageable pageable);
}
