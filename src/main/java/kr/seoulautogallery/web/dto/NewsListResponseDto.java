package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.News;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NewsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public NewsListResponseDto(News entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
