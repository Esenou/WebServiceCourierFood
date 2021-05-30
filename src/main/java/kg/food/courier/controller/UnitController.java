package kg.food.courier.controller;

import kg.food.courier.entity.Unit;
import kg.food.courier.service.UnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/unit")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/list")
    public String getListUnit(@PageableDefault(7) Pageable page, Model model) {
        Page<Unit> unitList;
        unitList = unitService.getAllByPageable(page);
        model.addAttribute("units", unitList);
        return "unitList";
    }
    @GetMapping("/form")
    public String getUnitForm(Model model){
        Unit unit = new Unit();
        model.addAttribute("unit",unit);
        model.addAttribute("add", true);
        return "unitForm";
    }
    @PostMapping("/create")
    public String createUnit(@ModelAttribute("unit") Unit unit,
                             BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute(unit);
            model.addAttribute("add", true);
            return "unitForm";
        }
        unitService.create(unit);
        return "redirect:/unit/list";
    }

    @GetMapping("/{id}")
    public String getUnitById(@PathVariable(required = false) Long id,
                              Model model){
        Unit unit = unitService.findById(id);
        model.addAttribute("unit",unit);
        model.addAttribute("add", false);
        return "unitForm";
    }
    @PostMapping("/update/{id}")
    public String updateUnit(@PathVariable Long id,
                             @ModelAttribute("unit") Unit unit,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute(unit);
            model.addAttribute("add", false);
            return "unitForm";
        }
        unit.setId(id);
        unitService.create(unit);
        return "redirect:/unit/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteUnit(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            unitService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "unitForm";
        }

        return "redirect:/unit/list";
    }

}
