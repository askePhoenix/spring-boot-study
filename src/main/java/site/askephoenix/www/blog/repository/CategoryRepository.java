package site.askephoenix.www.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.askephoenix.www.blog.model.CategoryInfo;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryInfo, Long> {
    Optional<CategoryInfo> findByName(String name);
}
