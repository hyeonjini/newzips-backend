package team.wbt.newzips.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.wbt.newzips.member.entity.Member;
import team.wbt.newzips.member.entity.Role;


@AllArgsConstructor
@Getter
public class MemberDto {
    private String email;
    private String alias;

    public MemberDto(Member member) {
        this.email = member.getEmail();
        this.alias = member.getAlias();
    }
}
