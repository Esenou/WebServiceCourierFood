package kg.food.courier.controller;

import kg.food.courier.entity.User;
import kg.food.courier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
        Page<User> managers;
        if(search != null) {
            managers = userService.findByUsernameWithSearch(pageable,search);
        } else {
            managers = userService.getAllByPageable(pageable);
            search = "";
        }
        model.addAttribute("orgId", orgId);
        model.addAttribute("search", search);
        model.addAttribute("managers", managers);
        return "organizationManagerList";
    }




    @GetMapping("{orgId}/manager/form")
    public String organizationManagerForm(@PathVariable("orgId") Long organizationId, Model model) {
        User manager = new User();
        model.addAttribute("manager", manager);
        model.addAttribute("organizationId", organizationId);
        model.addAttribute("add", true);
        return "organizationManagerForm";
    }

    @GetMapping(value = "{orgId}/manager/{managerId}")
    public String getFilialDetailPage(@PathVariable("managerId") Long managerId, @PathVariable("orgId") Long orgId, Model model) {
        User organizationManager = userService.findById(managerId);
        model.addAttribute("manager", organizationManager);
        model.addAttribute("orgId", orgId);
        model.addAttribute("add", false);
        return "organizationManagerForm";
    }

    @PostMapping(value = "{orgId}/manager/create")
    public String createOrganizationManager(@PathVariable("orgId") Long orgId,
                                            @Param("role") Boolean role,
                                            @ModelAttribute("manager") User organizationManagerDto,
                                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(organizationManagerDto);
            model.addAttribute("orgId", orgId);
            model.addAttribute("add", true);
            return "organizationManagerForm";
        }
        organizationManagerDto.setId(orgId);
        userService.create(organizationManagerDto);
        return "redirect:/organization/" + orgId + "/manager/list";
    }


    @PostMapping("{orgId}/manager/update/{managerId}")
    public String updateOrganizationManager(@PathVariable("orgId") Long orgId,
                                            @Param("role") Boolean role,
                                            @PathVariable("managerId") Long managerId,
                                            @ModelAttribute("manager") User organizationManagerDto,
                                            BindingResult result,
                                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(organizationManagerDto);
            model.addAttribute("organizationId", orgId);
            model.addAttribute("add", false);
            return "organizationManagerForm";
        }
        organizationManagerDto.setId(orgId);
        userService.update(organizationManagerDto);
        return "redirect:/organization/" + orgId + "/manager/list";
    }


    @GetMapping(value = "{orgId}/manager/delete/{managerId}")
    public String deleteFilial(@PathVariable("managerId") Long filId, @PathVariable("orgId") Long orgId) {
        userService.deleteById(filId);
        return "redirect:/organization/" + orgId + "/manager/list";
    }


}
