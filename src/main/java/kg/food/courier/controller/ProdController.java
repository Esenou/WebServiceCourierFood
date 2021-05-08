package kg.food.courier.controller;

import kg.food.courier.entity.Product;
import kg.food.courier.service.CategoryService;
import kg.food.courier.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/product")
public class ProdController {

    private final ProductService productService;
    private final CategoryService categoryService;

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
}
