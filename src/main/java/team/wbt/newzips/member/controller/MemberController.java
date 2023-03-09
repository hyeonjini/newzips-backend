package team.wbt.newzips.member.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.wbt.newzips.member.dto.MemberDto;
import team.wbt.newzips.member.dto.MembersWithCount;
import team.wbt.newzips.member.entity.Member;
import team.wbt.newzips.member.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/api/v1/member/members")
    public MembersWithCount members() {
        List<Member> members = memberService.members();
        List<MemberDto> collect = members.stream().map(MemberDto::new).collect(Collectors.toList());
        return new MembersWithCount(collect);
    }
}
