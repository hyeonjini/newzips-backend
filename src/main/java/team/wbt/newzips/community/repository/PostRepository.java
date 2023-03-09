package team.wbt.newzips.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.wbt.newzips.community.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
