package site.askephoenix.www.blog.dto;


import lombok.Getter;
import lombok.Setter;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.user.model.UserInfo;

@Getter
@Setter
public class BlogInfoDto {

    private String title;
    private String Category;

    public BlogInfoDto(BlogInfo info){
        this.title = info.getTitle();
        this.Category = info.getCategoryInfo() == null ? null : info.getCategoryInfo().getName();
    }
}
