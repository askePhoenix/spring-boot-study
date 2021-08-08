package site.askephoenix.www.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.askephoenix.www.user.dto.UserInfoDto;
import site.askephoenix.www.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;


    @GetMapping("/")
    public String rootView() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainView() {
        return "pages/main";
    }

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) {
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String loginView() {
        return "pages/login";
    }

    @GetMapping("/admin")
    public String adminView() {
        return "pages/admin";
    }

    @GetMapping("/signon")
    public String signupView() {
        return "pages/signon";
    }

    @GetMapping("/member/info")
    public String userInfoView() {
        return "pages/user_info";
    }

}
