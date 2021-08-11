package site.askephoenix.www.blog.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.askephoenix.www.blog.model.CategoryInfo;
import site.askephoenix.www.blog.repository.CategoryRepository;
import site.askephoenix.www.blog.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryInfo loadCategoryByName(String name) {
        return categoryRepository.findByName(name).orElseThrow();
    }

}
