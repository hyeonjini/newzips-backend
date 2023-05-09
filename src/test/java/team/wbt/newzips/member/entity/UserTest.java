package team.wbt.newzips.member.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.repository.UserRepository;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
class UserTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Test
    public void JpaEventBaseEntity() throws Exception {
        //given
        User user = new User("user@test.co.kr");
        userRepository.save(user); // @PrePersist 발생
        em.flush(); // @PreUpdate
        em.clear();

        //when
        List<User> findUsers = userRepository.findByEmail(user.getEmail());

        //then
        for (User findUser : findUsers) {
            System.out.println("findMember.createdDate = " + findUser.getCreatedDate());
            System.out.println("findMember.lastModifiedDate = " + findUser.getLastModifiedDate());
        }
    }
}