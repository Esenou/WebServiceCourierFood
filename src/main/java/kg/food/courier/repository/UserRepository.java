package kg.food.courier.repository;

import kg.food.courier.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {

    Page<User> findByOrganization_IdAndIdentification_Username(Long orgId, Pageable pageable, String username);

    Page<User> findByOrganization_Id(Long orgId,Pageable pageable);
}
