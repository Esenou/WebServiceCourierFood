package kg.food.courier.controller;

import kg.food.courier.entity.Organization;
import kg.food.courier.entity.Product;
import kg.food.courier.entity.Rate;
import kg.food.courier.entity.Unit;
import kg.food.courier.service.OrganizationService;
import kg.food.courier.service.ProductService;
import kg.food.courier.service.RateService;
import kg.food.courier.service.UnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("organization")
public class RateController {


    private final RateService rateService;
    private final ProductService productService;
    private final UnitService unitService;
    private final OrganizationService organizationService;

    public RateController(RateService rateService, ProductService productService, UnitService unitService, OrganizationService organizationService) {
        this.rateService = rateService;
        this.productService = productService;
        this.unitService = unitService;
        this.organizationService = organizationService;
    }

    private List<Product> productsList;
    private List<Unit> unitList;





    @GetMapping("{orgId}/rate/list")
    public String getList(@RequestParam(value = "search", required = false) String search,
                          @PageableDefault(5) Pageable pageable,
                          @PathVariable("orgId") Long orgId, Model model){
        Page<Rate> rates = (search!=null)?rateService.findByOrganization_IdAndProductLike(orgId,search,pageable):rateService.findAllByOrganization_Id(orgId,pageable);
        model.addAttribute("orgId", orgId);
        model.addAttribute("search", search);
        model.addAttribute("rates", rates);
        return "rateList";
    }

    @GetMapping("{orgId}/rate/form")
    public String rateForm(Model model){
        Rate rate = new Rate();
        model.addAttribute("add", true);
        model.addAttribute("rate", rate);
        model.addAttribute("materials", loadMaterials());
        model.addAttribute("unitList", loadUnits());
        return "rateForm";
    }

    @PostMapping("{orgId}/rate/create")
    public String createRate(@PathVariable(value = "orgId") Long orgId,  @ModelAttribute("rate") Rate rateModel,
                             BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("add",true);
            model.addAttribute("materials", loadMaterials());
            model.addAttribute("unitList", loadUnits());
            model.addAttribute(rateModel);
            return "rateForm";
        }

        rateModel.setOrganization(organizationService.findById(orgId));

        rateService.create(rateModel);
        return "redirect:/organization/" + orgId + "/rate/list";
    }

    private List<Product> loadMaterials(){
        return productsList == null ? productService.findByAll() : productsList;
    }

    private List<Unit> loadUnits(){
        return unitList == null ? unitService.findByAll() : unitList;
    }
}
