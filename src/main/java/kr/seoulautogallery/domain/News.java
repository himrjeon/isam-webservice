package kr.seoulautogallery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor // 기본 생성자 자동 추가 public posts() {}와 같은 효과
@Entity //  테이블과 링크될 클래스임을 나타냄.언더스코어네이밍으로 테이블이름매칭
public class News extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙. indentity를 추가해야만 자동증가가능.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼 나타내며 굳이 선언하지 않아도 가능함. 사용하는 이유는 추가 변경 옵션이 있을 때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스 빌더패턴 클래스 생성, 생성자 상단 선언시 생성자 포함된 필드만 빌더 포함
    public News(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
