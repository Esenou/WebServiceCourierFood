package kg.food.courier.repository;

import kg.food.courier.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CommonRepository<Basket> {
}
