package team.wbt.newzips.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.entity.Member;
import team.wbt.newzips.member.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        if (validationEmail(member.getEmail())){

        }
        return memberRepository.save(member).getId();
    }

    @Override
    public Boolean validationEmail(String email) {
        List<Member> findMember = memberRepository.findByEmail(email);
        return findMember.isEmpty();
    }

    @Override
    public List<Member> members() {
        List<Member> members = memberRepository.findAll();
        return members;
    }
}
