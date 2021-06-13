package kg.food.courier.controller;

import kg.food.courier.entity.User;
import kg.food.courier.enums.Role;
import kg.food.courier.model.OrgManagerDto;
import kg.food.courier.model.OrganizationManagerDto;
import kg.food.courier.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("organization/")
public class OrganizationManagerController {


    private final UserService userService;

    public OrganizationManagerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{orgId}/manager/list")
    public String getList(@RequestParam(value = "search" ,required = false) String search,
                          @PageableDefault(7) Pageable pageable,
                          @PathVariable("orgId") Long orgId,
                          Model model) {
        Page<User> managers = null;

        if(search != null) {
            managers = userService.findByUsernameWithSearch(orgId, pageable,search.toLowerCase());
        } else {
            managers = userService.findByOrganization_Id(orgId, pageable);

            search = "";
        }
        model.addAttribute("orgId", orgId);
        model.addAttribute("search", search);
        model.addAttribute("managers", managers);
        return "organizationManagerList";
    }

    @GetMapping("{orgId}/manager/form")
    public String organizationManagerForm(@PathVariable("orgId") Long organizationId, Model model) {

        model.addAttribute("manager", new OrganizationManagerDto());
        model.addAttribute("organizationId", organizationId);
        model.addAttribute("add", true);
        model.addAttribute("role", Role.values());
        return "organizationManagerForm";
    }

    @PostMapping(value = "{orgId}/manager/create")
    public String createOrganizationManager(@PathVariable("orgId") Long orgId,
                                            @ModelAttribute("manager") OrganizationManagerDto organizationManagerDto,
                                            BindingResult result, Model model)  {
       /* if (result.hasErrors()) {
            model.addAttribute(organizationManagerDto);
            model.addAttribute("orgId", orgId);
            model.addAttribute("add", true);
            return "organizationManagerForm";
        }*/
        organizationManagerDto.setOrganizationId(orgId);
        String results = userService.createOrganizationManager(organizationManagerDto);
        if(results.equals("999")){
            model.addAttribute("manager", new OrganizationManagerDto());
            model.addAttribute("organizationId", orgId);
            model.addAttribute("add", true);
            model.addAttribute("role", Role.values());
            return "organizationManagerForm";
        }
        return "redirect:/organization/" + orgId + "/manager/list";
    }


    @GetMapping(value = "{orgId}/manager/{managerId}")
    public String getFilialDetailPage(@PathVariable("managerId") Long managerId, @PathVariable("orgId") Long orgId, Model model) {
        User user = userService.findById(orgId);
      //  OrgManagerDto orgManagerDto = OrganizationManagerMapper.INSTANCE.identificationToDto(user.getIdentification());

        model.addAttribute("manager",  new OrganizationManagerDto());
        model.addAttribute("orgId", orgId);
        model.addAttribute("add", false);
        return "organizationManagerForm";
    }
}
