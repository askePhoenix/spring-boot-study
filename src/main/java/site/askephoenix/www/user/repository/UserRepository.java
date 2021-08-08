package site.askephoenix.www.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.askephoenix.www.user.model.UserInfo;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
}
