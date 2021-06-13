package kg.food.courier.repository;

import kg.food.courier.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CommonRepository<Product> {

    @Query(value = "select product from Product product where product.name like %?1% ")
    Page<Product> findByUsernameWithSearch(Pageable pageable, String value);

    @Query(value = "select product from Product product")
    Page<Product> getAllByPageable(Pageable pageable);
}
