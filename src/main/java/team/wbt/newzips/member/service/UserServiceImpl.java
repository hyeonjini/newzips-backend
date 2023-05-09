package team.wbt.newzips.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.member.entity.User;
import team.wbt.newzips.member.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Long join(User user) {
        if (validationEmail(user.getEmail()) == false) {
            throw new IllegalStateException("이미 등록된 이메일입니다.");
        }
        return userRepository.save(user).getId();
    }

    @Override
    public Boolean validationEmail(String email) {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        return userByEmail.isEmpty();
    }

    @Override
    public List<User> users() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email).stream().toList();
    }
}
