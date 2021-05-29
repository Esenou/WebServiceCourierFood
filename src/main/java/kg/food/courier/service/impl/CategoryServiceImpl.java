package kg.food.courier.service.impl;

import kg.food.courier.entity.Category;
import kg.food.courier.repository.CategoryRepository;
import kg.food.courier.service.CategoryService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryRepository> implements   CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> getAllByPageable(Pageable pageable) {
        return categoryRepository.getAllByPageable(pageable);
    }
}
