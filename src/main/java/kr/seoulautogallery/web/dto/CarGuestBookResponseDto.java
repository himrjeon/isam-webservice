package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.CarGuestBook;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CarGuestBookResponseDto {
    private Long id;
    private String carinfo;
    private String guestname;
    private String phonenum;
    private String email;
    private String content;
    private LocalDateTime modifiedDate;

    public CarGuestBookResponseDto(CarGuestBook entity) {
        this.id = entity.getId();
        this.carinfo = entity.getCarinfo();
        this.guestname = entity.getGuestname();
        this.phonenum = entity.getPhonenum();
        this.email = entity.getEmail();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
