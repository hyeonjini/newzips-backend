package team.wbt.newzips.member.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.wbt.newzips.member.dto.UserDto;
import team.wbt.newzips.member.dto.UsersWithCount;
import team.wbt.newzips.member.entity.User;
import team.wbt.newzips.member.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserControllerImp implements UserController {
    private final UserService userService;

    @GetMapping("/api/v1/member/members")
    public UsersWithCount users() {
        List<User> users = userService.users();
        List<UserDto> collect = users.stream().map(UserDto::new).collect(Collectors.toList());
        return new UsersWithCount(collect);
    }
}
