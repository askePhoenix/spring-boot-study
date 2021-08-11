package site.askephoenix.www.blog.dto;

import lombok.Getter;
import lombok.Setter;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.model.PostingInfo;

@Getter
@Setter
public class PostingInfoDto {
    private Long code;
    private String title;
    private BlogInfo blogInfo;
    private String contents;

    public PostingInfoDto(PostingInfo postingInfo) {
        this.code = postingInfo.getCode();
        this.title = postingInfo.getTitle();
        this.blogInfo = postingInfo.getBlogInfo();
        this.contents = postingInfo.getContents();
    }
}
