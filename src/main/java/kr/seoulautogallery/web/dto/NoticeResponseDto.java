package kr.seoulautogallery.web.dto;


import kr.seoulautogallery.domain.Notice;
import lombok.Getter;

@Getter
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}