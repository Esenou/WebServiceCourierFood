package kg.food.courier.service.impl;

import kg.food.courier.entity.Organization;
import kg.food.courier.repository.OrganizationRepository;
import kg.food.courier.service.OrganizationService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, OrganizationRepository> implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        super(organizationRepository);
        this.organizationRepository = organizationRepository;
    }
}
