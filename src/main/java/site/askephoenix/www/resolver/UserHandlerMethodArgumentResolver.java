package site.askephoenix.www.resolver;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import site.askephoenix.www.annotation.LoginUser;
import site.askephoenix.www.user.model.UserInfo;

@Slf4j
@Component
public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null)
            throw new IllegalArgumentException("사용자 정보가 존재하지 않습니다.");

        final UserInfo userInfo = (UserInfo) auth.getPrincipal();

        final LoginUser loginUser = methodParameter.getParameterAnnotation(LoginUser.class);

        if (loginUser == null || userInfo == null)
            throw new IllegalArgumentException("사용자 정보가 존재하지 않습니다.");

        return userInfo;
    }
}
