package kg.food.courier.repository;

import kg.food.courier.entity.Category;
import kg.food.courier.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepository extends CommonRepository<Unit>{
    @Query(value = "select unit from Unit unit")
    Page<Unit> getAllByPageable(Pageable pageable);
}
