package kg.food.courier.service.impl;

import kg.food.courier.entity.Identification;
import kg.food.courier.entity.Organization;
import kg.food.courier.entity.User;
import kg.food.courier.enums.StatusList;
import kg.food.courier.model.OrganizationManagerDto;
import kg.food.courier.repository.UserRepository;
import kg.food.courier.service.IdentificationService;
import kg.food.courier.service.UserService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {


    private final UserRepository userRepository;

    private final IdentificationService identificationService;

    public UserServiceImpl(UserRepository userRepository, IdentificationService identificationService) {
        super(userRepository);
        this.userRepository = userRepository;
        this.identificationService = identificationService;
    }

    @Override
    public Page<User> findByUsernameWithSearch(Long orgId, Pageable pageable, String value) {
        return userRepository.findByOrganization_IdAndIdentification_Username(orgId,pageable,value);
    }

    @Override
    public Page<User> findByOrganization_Id(Long orgId, Pageable pageable) {
        return userRepository.findByOrganization_Id(orgId,pageable);
    }

    @Override
    public String createOrganizationManager(OrganizationManagerDto organizationManagerDto){

        try {
            Identification  identification = new Identification();
            identification.setUsername(organizationManagerDto.getUsername());
            identification.setPassword(organizationManagerDto.getPassword());
            identification.setStatus(StatusList.ACTIVE);
            identificationService.create(identification);

            Organization organization = new Organization();
            organization.setId(organizationManagerDto.getOrganizationId());

            identification = identificationService.findByUsername(organizationManagerDto.getUsername());

            User ob = User.builder()
                    .organization(organization)
                    .identification(identification)
                    .role(organizationManagerDto.getRole())
                    .status(StatusList.ACTIVE)
                    .build();
            userRepository.save(ob);
            return "000";

        }catch (Exception e){
            return "999";
        }
    }

    @Override
    public String updateOrganizationManager(OrganizationManagerDto organizationManagerDto) {
        return null;
    }
}
