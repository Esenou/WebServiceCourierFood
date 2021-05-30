package kg.food.courier.controller;

import kg.food.courier.entity.Category;
import kg.food.courier.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String getCategoryList(@PageableDefault(10) Pageable pageable, Model model) {
        Page<Category> categoryList = categoryService.getAllByPageable(pageable);
        model.addAttribute("orgCategories", categoryList);
        model.addAttribute("add", false);
        return "categoryList";
    }

    @GetMapping("/form")
    public String getCategoryForm(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        model.addAttribute("add", true);
        return "categoryForm";
    }


    @PostMapping("/create")
    public String createCategory( @ModelAttribute("category") Category category,
                                 BindingResult result, Model model){
       /* if (result.hasErrors()) {
            model.addAttribute(category);
            model.addAttribute("add", true);
            return "orgCategoryForm";
        }*/
        categoryService.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable (required = false) Long id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("add", false);
        return "categoryForm";

    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable(required = false) Long id,
                                 @ModelAttribute("category") Category category,
                                 BindingResult result,Model model){
        /*if (result.hasErrors()) {
            category.setId(id);
            model.addAttribute(category);
            return "categoryForm";
        }*/
        category.setId(id);
        categoryService.create(category);
        return "redirect:/category/list";
    }

    @PostMapping ("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            categoryService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/category/"+id;
        }
        return "redirect:/category/list";
    }



}
