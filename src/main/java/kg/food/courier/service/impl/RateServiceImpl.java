package kg.food.courier.service.impl;

import kg.food.courier.entity.Rate;
import kg.food.courier.repository.RateRepository;
import kg.food.courier.service.RateService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl extends BaseServiceImpl<Rate, RateRepository> implements RateService {

    private final RateRepository rateRepository;
    public RateServiceImpl(RateRepository rateRepository) {
        super(rateRepository);
        this.rateRepository = rateRepository;
    }

    @Override
    public Page<Rate> findByOrganization_IdAndProductLike(Long orgId, String value, Pageable pageable) {
        return rateRepository.findByOrganization_IdAndProductLike(orgId,value,pageable);
    }

    @Override
    public Page<Rate> findAllByOrganization_Id(Long id, Pageable pageable) {
        return rateRepository.findAllByOrganization_Id(id,pageable);
    }


}
