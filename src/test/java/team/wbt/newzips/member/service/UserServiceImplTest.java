package team.wbt.newzips.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.entity.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    UserService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Long memberId = memberService.join(new User("test@co.kr"));

        //when
        List<User> byEmail = memberService.findByEmail("test@co.kr");
        User findUser = byEmail.get(0);
        //then
        assertThat(byEmail.size()).isEqualTo(1);
        assertThat(findUser.getEmail()).isEqualTo("test@co.kr");
    }

    @Test
    public void 회원가입_중복이메일_예외() throws Exception {
        //given
        Long memberId = memberService.join(new User("test@co.kr"));

        //when

        //then

    }



}