package kg.food.courier.repository;
import kg.food.courier.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RateRepository extends CommonRepository<Rate>{

    Page<Rate>findByOrganization_IdAndProductLike(Long orgId,String value,Pageable pageable);

    Page<Rate>findAllByOrganization_Id(Long orgId,Pageable pageable);
}
