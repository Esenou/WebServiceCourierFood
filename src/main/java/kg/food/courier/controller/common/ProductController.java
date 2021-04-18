package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.Product;
import kg.food.courier.service.ProductService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController extends BaseController<Product, ProductService> {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }
}
