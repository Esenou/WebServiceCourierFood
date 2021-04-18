package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.Organization;
import kg.food.courier.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organization")
public class OrganizationController extends BaseController<Organization, OrganizationService> {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        super(organizationService);
        this.organizationService = organizationService;
    }
}
