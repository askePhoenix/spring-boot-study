package site.askephoenix.www.blog.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class PostingInfo {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @JoinColumn(name = "blog_id")
    @ManyToOne
    private BlogInfo blogInfo;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;




    @CreationTimestamp
    private LocalDateTime createTimeAt;

    @UpdateTimestamp
    private LocalDateTime updateTimeAt;

    @Builder
    public PostingInfo( BlogInfo blogInfo, String title, String contents ){
        this.blogInfo = blogInfo;
        this.title = title;
        this.contents = contents;
    }

}
