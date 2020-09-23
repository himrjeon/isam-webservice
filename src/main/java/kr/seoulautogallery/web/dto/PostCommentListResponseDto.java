package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.PostComment;
import kr.seoulautogallery.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostCommentListResponseDto {
    private Long commentid;
    private String memo;
    private String author;
    private LocalDateTime modifiedDate;

    public PostCommentListResponseDto(PostComment entity) {
        this.commentid = entity.getCommentid();
        this.memo = entity.getMemo();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
