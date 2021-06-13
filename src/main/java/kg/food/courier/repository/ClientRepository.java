package kg.food.courier.repository;

import kg.food.courier.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CommonRepository<Client> {

    @Query(value = "from Client user where user.name like %?1% ")
    Page<Client> findByUsernameWithSearch(Pageable pageable, String value);

    @Query(value = "from Client user")
    Page<Client> getAllByPageable(Pageable pageable);


}
