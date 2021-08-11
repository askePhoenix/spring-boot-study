package site.askephoenix.www.blog.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.askephoenix.www.user.model.UserInfo;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class BlogInfo {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @JoinColumn(name = "user_id")
    @OneToOne
    private UserInfo userInfo;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private CategoryInfo categoryInfo;

    @Column(name = "title")
    private String title;


    @Builder
    public BlogInfo(CategoryInfo categoryInfo, UserInfo userInfo, Long code, String title) {
        this.categoryInfo = categoryInfo;
        this.userInfo = userInfo;
        this.title = title;
        this.code = code;
    }

}
