package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.News;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public NewsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public News toEntity() {
        return News.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
