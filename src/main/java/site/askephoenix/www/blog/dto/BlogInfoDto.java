package site.askephoenix.www.blog.dto;


import lombok.Getter;
import lombok.Setter;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.model.CategoryInfo;
import site.askephoenix.www.user.model.UserInfo;

@Getter
@Setter
public class BlogInfoDto {
    private Long code;
    private String title;
    private CategoryInfo Category;

    public BlogInfoDto() {
    }

    public BlogInfoDto(BlogInfo info) {
        this.code = info.getCode();
        this.title = info.getTitle();
        this.Category = info.getCategoryInfo() == null ? null : info.getCategoryInfo();
    }
}
