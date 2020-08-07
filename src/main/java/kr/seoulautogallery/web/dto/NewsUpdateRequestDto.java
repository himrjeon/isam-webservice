package kr.seoulautogallery.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public NewsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
