package site.askephoenix.www.blog.service;

import site.askephoenix.www.blog.dto.PostingInfoDto;
import site.askephoenix.www.user.model.UserInfo;

public interface PostingService {
    Long save(UserInfo userInfo, PostingInfoDto postingInfoDto);

    Long update(UserInfo userInfo, PostingInfoDto postingInfoDto);
}
