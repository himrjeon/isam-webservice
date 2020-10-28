package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.GuestBook;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GuestBookResponseDto{
    private Long id;
    private String guestname;
    private String phonenum;
    private String email;
    private String content;
    private String nowcar;
    private String salecheck;
    private LocalDateTime modifiedDate;

    public GuestBookResponseDto(GuestBook entity) {
        this.id = entity.getId();
        this.guestname = entity.getGuestname();
        this.phonenum = entity.getPhonenum();
        this.email = entity.getEmail();
        this.content = entity.getContent();
        this.nowcar = entity.getNowcar();
        this.salecheck = entity.getSalecheck();
        this.modifiedDate = entity.getModifiedDate();
    }
}