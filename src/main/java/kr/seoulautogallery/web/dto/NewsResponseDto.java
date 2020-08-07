package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.News;
import lombok.Getter;

@Getter
public class NewsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public NewsResponseDto(News entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
