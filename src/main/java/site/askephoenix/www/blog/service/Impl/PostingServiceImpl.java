package site.askephoenix.www.blog.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.askephoenix.www.blog.dto.PostingInfoDto;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.model.PostingInfo;
import site.askephoenix.www.blog.repository.PostingRepository;
import site.askephoenix.www.blog.service.BlogService;
import site.askephoenix.www.blog.service.PostingService;
import site.askephoenix.www.user.model.UserInfo;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {
    private final PostingRepository postingRepository;
    private final BlogService blogService;

    @Override
    public Long save(UserInfo userInfo, PostingInfoDto postingInfoDto) {
        return postingRepository.save(
                PostingInfo.builder()
                        .title(postingInfoDto.getTitle())
                        .contents(postingInfoDto.getContents())
                        .blogInfo(blogService.getBlogByUserEmail(userInfo.getEmail()))
                        .build()
        ).getCode();
    }

    @Override
    public Long update(UserInfo userInfo, PostingInfoDto postingInfoDto) {
        return postingRepository.save(PostingInfo.builder()
                .code(postingInfoDto.getCode())
                .title(postingInfoDto.getTitle())
                .contents(postingInfoDto.getContents())
                .blogInfo( blogService.getBlogByUserEmail(userInfo.getEmail()) )
                .build()
        ).getCode();
    }
}
