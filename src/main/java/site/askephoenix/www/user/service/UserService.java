package site.askephoenix.www.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import site.askephoenix.www.blog.model.BlogInfo;
import site.askephoenix.www.blog.repository.BlogRepository;
import site.askephoenix.www.user.model.UserInfo;
import site.askephoenix.www.user.dto.UserInfoDto;
import site.askephoenix.www.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService  implements UserDetailsService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    @Override
    public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        final UserInfo user = userRepository.save(UserInfo.builder()
                .email(infoDto.getEmail())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword()).build()
        );

        blogRepository.save(BlogInfo.builder()
                .userInfo(user)
                .build()
        );

        return user.getCode();
    }
}
