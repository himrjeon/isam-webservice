package kr.seoulautogallery.web.dto;


import kr.seoulautogallery.domain.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public NoticeListResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}