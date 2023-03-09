package team.wbt.newzips.common.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass // 진짜 JPA 상속 관계가 아닌 속성만 내려서 사용할 수 있는 어노테이션
@Getter
public class JpaBaseEntity {

    @Column(updatable = false) // 변경 되지 않도록 설정
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist // Persist 하기 전 발생하는 이벤트
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
