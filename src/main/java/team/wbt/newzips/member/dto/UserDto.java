package team.wbt.newzips.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.wbt.newzips.member.entity.User;


@AllArgsConstructor
@Getter
public class UserDto {
    private String email;
    private String alias;

    public UserDto(User user) {
        this.email = user.getEmail();
        this.alias = user.getAlias();
    }
}
