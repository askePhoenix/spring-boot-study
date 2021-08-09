package site.askephoenix.www.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.askephoenix.www.annotation.LoginUser;
import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;
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

    @GetMapping("/{email:.+}/")
    public BlogInfoDto loadBlogApi(@PathVariable("email") String email) {

        return blogService.loadBlogByUserEmail(email);
    }

    @PostMapping("/{email:.+}/")
    public void createBlogApi(@PathVariable("email") String email) {
        blogService.createBlog(email);
    }

    @GetMapping("/Test")
    public void TTest(@LoginUser UserInfo user) {
        System.out.println("TTest");
        System.out.println(user);
    }
}
