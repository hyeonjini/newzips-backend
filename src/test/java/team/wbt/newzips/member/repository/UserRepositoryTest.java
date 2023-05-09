package team.wbt.newzips.member.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.entity.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository memberRepository;

    @Test
    public void findUserByEmail() throws Exception {
        //given
        User user = new User("test@co.kr");
        memberRepository.save(user);

        //when
        Optional<User> memberByEmail = memberRepository.findUserByEmail("test@co.kr");
        User findUser = memberByEmail.orElse(new User("null@co.kr"));

        Optional<User> memberByEmail1 = memberRepository.findUserByEmail("null@co.kr");
        User findUser1 = memberByEmail1.orElse(new User("null@co.kr"));

        //then
        assertThat(findUser.getEmail()).isEqualTo("test@co.kr");
        assertThat(findUser1.getEmail()).isEqualTo("null@co.kr");
    }
}