package kg.food.courier.service.impl;


import kg.food.courier.entity.Product;
import kg.food.courier.repository.ProductRepository;
import kg.food.courier.service.ProductService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductRepository> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl( ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
}
