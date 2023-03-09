package team.wbt.newzips.community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.wbt.newzips.common.entity.BaseTimeEntity;
import team.wbt.newzips.common.entity.Status;
import team.wbt.newzips.member.entity.Member;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    private String content;
    private int userLike;
    private int userDislike;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    /**
     * 생성 메서드
     */
    public static Comment createComment(String content, Post post, Member member) {
        Comment comment = new Comment();
        comment.comment(content);
        comment.setPost(post);
        comment.setMember(member);
        return comment;
    }

    /**
     * 연관관계 메서드
     */
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getComments().add(this);
    }

    /**
     * 비지니스 로직
     */
    public void comment(String content) {
        this.content = content;
        this.userLike = 0;
        this.userDislike = 0;
        this.status = Status.CREATED;
    }

    public void update(String content) {
        this.content = content;
    }
}
