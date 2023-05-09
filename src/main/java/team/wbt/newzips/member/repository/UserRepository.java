package team.wbt.newzips.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import team.wbt.newzips.member.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(@Param("email") String email);
    Optional<User> findUserByEmail(@Param("email") String email);
    User findByUserId(String id);
}
