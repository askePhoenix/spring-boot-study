package site.askephoenix.www.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.user.model.UserInfo;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogInfo, Long> {
    Optional<BlogInfo> findByUserInfo(UserInfo userInfo);
}
