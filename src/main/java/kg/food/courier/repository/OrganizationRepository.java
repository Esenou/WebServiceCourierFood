package kg.food.courier.repository;

import kg.food.courier.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends CommonRepository<Organization>{

    @Query(value = "select organization from Organization organization where organization.name like %?1% ")
    Page<Organization> findByOrganizationNameWithSearch(Pageable pageable, String value);

    @Query(value = "select organization from Organization organization")
    Page<Organization> getAllByPageable(Pageable pageable);
}
