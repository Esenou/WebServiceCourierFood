package kg.food.courier.controller;

import kg.food.courier.entity.Category;
import kg.food.courier.entity.Organization;
import kg.food.courier.entity.User;
import kg.food.courier.enums.StatusList;
import kg.food.courier.model.OrganizationModel;
import kg.food.courier.service.CategoryService;
import kg.food.courier.service.OrganizationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@RequestMapping("organization/")
public class OrgController {

    private final OrganizationService organizationService;
    private final CategoryService categoryService;
    public OrgController(OrganizationService organizationService, CategoryService categoryService) {
        this.organizationService = organizationService;
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public String getOranizationList(Model model, @RequestParam(value = "search", required = false) String search,
                                     @PageableDefault(7) Pageable pageable) {
        Page<Organization> organizationList;
        List<Category> orgCategories = categoryService.findByAll();
        if (search != null) {
           organizationList = organizationService.findByOrganizationNameWithSearch(pageable,search);
        }
        else {
            organizationList = organizationService.getAllByPageable(pageable);
        }

        model.addAttribute("organizations", organizationList);
        model.addAttribute("orgCategories", orgCategories);
        return "organizationList";
    }

    @GetMapping(value = "/{id}")
    public String organizationProfile(@PathVariable(required = false) Long id, Model model){
        Organization organization = organizationService.findById(id);
        List<Category> orgCategories = categoryService.findByAll();
        model.addAttribute("status", StatusList.values());
        model.addAttribute("organization", organization);
        model.addAttribute("orgCategories", orgCategories);
        return "organizationForm";
    }

    @PostMapping("update/{id}")
    public String updateOrganization(@PathVariable("id") Long id,@ModelAttribute("organization") Organization organization,
                                     BindingResult result,Model model){
        if(result.hasErrors()){
            /*Organization organizations = organizationService.findById(id);
            model.addAttribute("organization", organizations);
            return "organizationForm";*/
        }
        organization.setId(id);
        organizationService.create(organization);
        return "redirect:/organization/list";
    }

    @GetMapping("/form")
    public String organizationForm(Model model){
        Organization organization = new Organization();
        List<Category> orgCategories = categoryService.findByAll();
        model.addAttribute("organization", organization);
        model.addAttribute("orgCategories", orgCategories);
        model.addAttribute("add", true);
        return "organizationForm";

    }

    @PostMapping(value = "/create")
    public String addOrganization( @ModelAttribute("organization") Organization organizationModelImage,
                                  BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            model.addAttribute(organizationModelImage);
            model.addAttribute("add", true);
            return "organizationForm";
        }*/
        organizationService.create(organizationModelImage);
        return "redirect:list";
    }

    @PostMapping(value = "delete/{id}")
    public String deleteOrganization(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            organizationService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/organization/"+id;
        }
        return "redirect:/organization/list";
    }


}
