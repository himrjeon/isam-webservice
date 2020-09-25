package kr.seoulautogallery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Popup extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String linkPath;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Builder
    public Popup(Long id, String title, String filePath, String linkPath) {
        this.id = id;
        this.title = title;
        this.linkPath = linkPath;
        this.filePath = filePath;
    }

    public void update(String title, String linkPath, String filePath) {
        this.title = title;
        this.linkPath = linkPath;
        this.filePath = filePath;
    }


}