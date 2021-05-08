package kg.food.courier.repository;

import kg.food.courier.entity.User;
import kg.food.courier.model.ClientShortModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {

    @Query(value = "select user from User user where user.name like %?1% ")
    Page<User> findByUsernameWithSearch(Pageable pageable, String value);

    @Query(value = "select user from User user")
    Page<User> getAllByPageable(Pageable pageable);


}
