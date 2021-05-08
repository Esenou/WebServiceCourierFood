package kg.food.courier.repository;

import kg.food.courier.entity.Organization;
import kg.food.courier.entity.User;
import kg.food.courier.model.OrganizationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends CommonRepository<Organization>{

    @Query(value = "select organization from Organization organization where organization.name like %?1% ")
    Page<Organization> findByOrganizationNameWithSearch(Pageable pageable, String value);

    @Query(value = "select organization from Organization organization")
    Page<Organization> getAllByPageable(Pageable pageable);
}
