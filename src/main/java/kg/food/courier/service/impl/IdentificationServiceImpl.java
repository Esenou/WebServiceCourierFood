package kg.food.courier.service.impl;

import kg.food.courier.entity.Identification;
import kg.food.courier.repository.IdentificationRepository;
import kg.food.courier.service.IdentificationService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class IdentificationServiceImpl extends BaseServiceImpl<Identification, IdentificationRepository> implements IdentificationService {

    private final IdentificationRepository identificationRepository;

    public IdentificationServiceImpl(IdentificationRepository identificationRepository) {
        super(identificationRepository);
        this.identificationRepository = identificationRepository;
    }

    @Override
    public Identification findByUsername(String username) {
        return identificationRepository.findByUsername(username);
    }
}
