package kg.food.courier.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

}
