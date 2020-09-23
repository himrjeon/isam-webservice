package kr.seoulautogallery.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCommentUpdateRequestDto {
    private String memo;


    @Builder
    public PostCommentUpdateRequestDto(String memo) {
        this.memo = memo;
    }
}
