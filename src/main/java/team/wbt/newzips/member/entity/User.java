package team.wbt.newzips.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.wbt.newzips.common.entity.BaseTimeEntity;
import team.wbt.newzips.common.entity.Status;
import team.wbt.newzips.community.entity.Comment;
import team.wbt.newzips.community.entity.Post;
import team.wbt.newzips.oauth.entity.ProviderType;
import team.wbt.newzips.oauth.entity.RoleType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;
    private RoleType roleType;
    private ProviderType providerType;
    private String alias;
    private Boolean submit;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public User(String email) {
        this.email = email;
    }
}
