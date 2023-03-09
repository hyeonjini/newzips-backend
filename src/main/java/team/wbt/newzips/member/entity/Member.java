package team.wbt.newzips.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.wbt.newzips.common.entity.BaseTimeEntity;
import team.wbt.newzips.common.entity.Status;
import team.wbt.newzips.community.entity.Comment;
import team.wbt.newzips.community.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private Role role;
    private String alias;
    private Boolean submit;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    public Member(String email) {
        email = email;
    }
}
