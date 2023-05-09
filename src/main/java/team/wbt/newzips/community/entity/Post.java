package team.wbt.newzips.community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.wbt.newzips.common.entity.BaseTimeEntity;
import team.wbt.newzips.common.entity.Status;
import team.wbt.newzips.member.entity.User;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;
    private int userLike;
    private int userDislike;
    private int views;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    /**
     * 연관관계 메서드
     */
    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }

    /**
     * 생성 메서드
     */
    public static Post createPost(String title, String content, User user) {
        Post post = new Post();
        post.post(title, content);
        post.setUser(user);
        return post;
    }

    /**
     * 비지니스 로직
     */
    public void post(String title, String content) {
        this.title = title;
        this.content = content;
        this.userLike = 0;
        this.userDislike = 0;
        this.views = 0;
        this.status = Status.CREATED;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void like() {
        this.userLike++;
    }

    public void dislike() {
        this.userDislike++;
    }

    public void view() {
        this.views++;
    }
}
