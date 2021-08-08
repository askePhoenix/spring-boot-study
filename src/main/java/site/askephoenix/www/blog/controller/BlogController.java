package site.askephoenix.www.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.service.BlogService;

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
}
