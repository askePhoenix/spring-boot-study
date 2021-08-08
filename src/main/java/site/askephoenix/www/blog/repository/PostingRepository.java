package site.askephoenix.www.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.model.CategoryInfo;
import site.askephoenix.www.blog.model.PostingInfo;

import java.util.Optional;

public interface PostingRepository extends JpaRepository<PostingInfo, Long> {
    Optional<PostingInfo> findByBlogInfo(BlogInfo blogInfo);
}
