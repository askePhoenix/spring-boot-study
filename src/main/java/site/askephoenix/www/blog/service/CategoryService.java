package site.askephoenix.www.blog.service;

import site.askephoenix.www.blog.model.CategoryInfo;

import java.util.Optional;

public interface CategoryService {
    CategoryInfo loadCategoryByName(String name);
}
