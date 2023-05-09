package team.wbt.newzips.member.service;

import team.wbt.newzips.member.entity.User;

import java.util.List;

public interface UserService {
    Long join(User user);
    Boolean validationEmail(String email);
    List<User> users();
    List<User> findByEmail(String email);
}
