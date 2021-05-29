package kg.food.courier.repository;

import kg.food.courier.entity.Category;
import kg.food.courier.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends CommonRepository<Category>{
    @Query(value = "select category from Category category")
    Page<Category> getAllByPageable(Pageable pageable);
}
