package team.wbt.newzips.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.wbt.newzips.community.repository.CommentRepository;
import team.wbt.newzips.community.repository.PostRepository;
import team.wbt.newzips.member.entity.User;
import team.wbt.newzips.member.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityServiceImpl implements CommunityService{
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long post(String title, String content, String authorEmail) {
        List<User> findUser = userRepository.findByEmail(authorEmail);
        return null;
    }
}
