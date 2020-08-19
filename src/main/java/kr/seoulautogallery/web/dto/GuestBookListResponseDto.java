package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.GuestBook;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GuestBookListResponseDto {
    private Long id;
    private String guestname;
    private String phonenum;
    private String email;
    private String content;
    private LocalDateTime modifiedDate;

    public GuestBookListResponseDto(GuestBook entity) {
        this.id = entity.getId();
        this.guestname = entity.getGuestname();
        this.phonenum = entity.getPhonenum();
        this.email = entity.getEmail();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
