package site.askephoenix.www.blog.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.askephoenix.www.annotation.LoginUser;
import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.service.BlogService;
import site.askephoenix.www.user.model.UserInfo;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("blog")
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/")
    public HashMap<String, Object> blogView() {
        return null;
    }

    @PatchMapping("/")
    public HashMap<String, Object> updateBlog(
            @LoginUser UserInfo userInfo,
            BlogInfoDto blogInfoDto) {
        return Maps.newHashMap( ImmutableMap.<String,Object> builder()
                .put("Action", "Update")
                .put("code", blogService.update( userInfo, blogInfoDto ))
                .build()
        );
    }

    @GetMapping("/{email:.+}")
    public BlogInfoDto loadBlogApi(@PathVariable("email") String email) {
        return blogService.loadBlogByUserEmail(email);
    }

    @PostMapping("/{email:.+}")
    public void createBlogApi(@PathVariable("email") String email) {
        blogService.createBlog(email);
    }

}
