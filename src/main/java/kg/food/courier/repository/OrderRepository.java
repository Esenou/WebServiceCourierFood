package kg.food.courier.repository;

import kg.food.courier.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CommonRepository<Order> {

}
