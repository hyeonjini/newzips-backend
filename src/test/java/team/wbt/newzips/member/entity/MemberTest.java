package team.wbt.newzips.member.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.repository.MemberRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void JpaEventBaseEntity() throws Exception {
        //given
        Member member = new Member("member@test.co.kr");
        memberRepository.save(member); // @PrePersist 발생
        em.flush(); // @PreUpdate
        em.clear();

        //when
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());

        //then
        for (Member findMember : findMembers) {
            System.out.println("findMember.createdDate = " + findMember.getCreatedDate());
            System.out.println("findMember.lastModifiedDate = " + findMember.getLastModifiedDate());
        }
    }
}