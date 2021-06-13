package kg.food.courier.controller;


import kg.food.courier.entity.Category;
import kg.food.courier.entity.Product;
import kg.food.courier.service.CategoryService;
import kg.food.courier.service.ProductService;
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
@RequestMapping("/product")
public class ProdController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private List<Category> categories;

    public ProdController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String getProductList(@RequestParam(value = "search", required = false) String search,
                                 @PageableDefault(5) Pageable pageable,
                                 Model model) {
        Page<Product> products = (search != null) ? productService.findByUsernameWithSearch(pageable, search) : productService.getAllByPageable(pageable);
        model.addAttribute("materials", products);
        return "productList";
    }

    @GetMapping("/form")
    public String getProductForm(Model model){
        Product product = new Product();
        model.addAttribute("material",product);
        model.addAttribute("add",true);
        model.addAttribute("categories",loadCategories());
        return "productForm";
    }

    @PostMapping ("create")
    public String creatProduct(@ModelAttribute("material") Product product,
                               BindingResult result,  Model model){

        /*if (result.hasErrors()) {
            model.addAttribute(product);
            model.addAttribute("categories", loadCategories());
            model.addAttribute("add", true);
            return "productForm";
        }*/
        productService.create(product);

        return "redirect:/product/list";
    }

    private List<Category> loadCategories() {
         return categories == null ? categoryService.findByAll() : categories;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable(required = false) Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("material", product);
        model.addAttribute("categories", loadCategories());
        model.addAttribute("add", false);
        return "productForm";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable(required = false) Long id, Model model,
                                @ModelAttribute("materials") Product product,
                                BindingResult result){
        /*if (result.hasErrors()) {
            model.addAttribute(product);
            model.addAttribute("categories", loadCategories());
            model.addAttribute("add", false);
            return "productForm";
        }*/
        product.setId(id);
        productService.create(product);
        return "redirect:/product/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            productService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            redirectAttributes.addFlashAttribute("exception_text", "Couldn't delete on table material violates foreign key constraint ");
            return "redirect:/product/"+id;
        }
        return "redirect:/product/list";
    }


}
