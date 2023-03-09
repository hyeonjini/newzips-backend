package team.wbt.newzips.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.entity.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);
    Boolean validationEmail(String email);
    List<Member> members();
}
