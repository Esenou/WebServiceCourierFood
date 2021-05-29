package kg.food.courier.service;

import kg.food.courier.entity.Category;
import kg.food.courier.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends BaseService<Category> {
    Page<Category> getAllByPageable(Pageable pageable);
}
