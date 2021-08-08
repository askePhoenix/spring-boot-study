package site.askephoenix.www.blog.service.Impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.repository.BlogRepository;
import site.askephoenix.www.blog.service.BlogService;
import site.askephoenix.www.blog.service.CategoryService;
import site.askephoenix.www.user.dto.UserInfoDto;
import site.askephoenix.www.user.model.UserInfo;
import site.askephoenix.www.user.service.UserService;

import java.util.HashMap;


@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    @Override
    public BlogInfoDto loadBlogByUserEmail(String email) {
        return new BlogInfoDto(blogRepository.findByUserInfo(
                userService.loadUserByUsername(email)
        ).orElseThrow(() -> new UsernameNotFoundException(email))
        );
    }

    @Override
    public void createBlog(String email) {

    }

    public Long save(BlogInfoDto infoDto, UserInfo user){
        return blogRepository.save(BlogInfo.builder()
                .userInfo(user)
                .categoryInfo( categoryService.loadCategoryByName(infoDto.getCategory()) )
                .build()

        ).getCode();
    }
}
