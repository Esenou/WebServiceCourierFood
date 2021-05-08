package kg.food.courier.repository;

import kg.food.courier.entity.BaseEntity;
import kg.food.courier.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
