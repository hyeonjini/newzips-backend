package team.wbt.newzips.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.wbt.newzips.community.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
