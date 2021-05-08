package kg.food.courier.service.impl;

import kg.food.courier.entity.Organization;
import kg.food.courier.model.OrganizationModel;
import kg.food.courier.repository.OrganizationRepository;
import kg.food.courier.service.OrganizationService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, OrganizationRepository> implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        super(organizationRepository);
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Page<Organization> findByOrganizationNameWithSearch(Pageable pageable, String value) {
        return organizationRepository.findByOrganizationNameWithSearch(pageable,value);
    }

    @Override
    public Page<Organization> getAllByPageable(Pageable pageable) {
        return organizationRepository.getAllByPageable(pageable);
    }
}
