package site.askephoenix.www.blog.service;


import site.askephoenix.www.blog.dto.BlogInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.user.model.UserInfo;



public interface BlogService {

    BlogInfoDto loadBlogByUserEmail(String email);

    BlogInfo getBlogByUserEmail(String email);

    void createBlog(String email);

    Long update(UserInfo userInfo, BlogInfoDto blogInfoDto);


    Long save(BlogInfoDto infoDto, UserInfo user);
}
