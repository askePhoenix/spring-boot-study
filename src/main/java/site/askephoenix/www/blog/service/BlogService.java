package site.askephoenix.www.blog.service;


import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;


public interface BlogService {

    BlogInfoDto loadBlogByUserEmail(String email);

    void createBlog(String email);
}
