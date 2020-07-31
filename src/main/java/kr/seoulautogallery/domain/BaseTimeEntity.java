package kr.seoulautogallery.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTime을 상속하면 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //현재 클래스에 Auditing 기능을 포함
public class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 엔티티값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}
