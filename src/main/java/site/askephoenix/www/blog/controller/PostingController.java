package site.askephoenix.www.blog.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.askephoenix.www.annotation.LoginUser;
import site.askephoenix.www.blog.dto.PostingInfoDto;
import site.askephoenix.www.blog.service.PostingService;
import site.askephoenix.www.user.model.UserInfo;

import java.util.HashMap;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/")
    public HashMap<String, Object> createPosting(
            @LoginUser UserInfo userInfo,
            @RequestParam PostingInfoDto postingInfoDto
    ) {
        return Maps.newHashMap(ImmutableMap.<String, Object>builder()
                .put("code", postingService.save(userInfo, postingInfoDto))
                .build()
        );
    }

    @PatchMapping("/")
    public HashMap<String, Object> updatePosting(
            @LoginUser UserInfo userInfo,
            PostingInfoDto postingInfoDto
    ) {
        return Maps.newHashMap(ImmutableMap.<String, Object>builder()
                .put("code", postingService.update(userInfo, postingInfoDto))
                .build()
        );
    }
}
