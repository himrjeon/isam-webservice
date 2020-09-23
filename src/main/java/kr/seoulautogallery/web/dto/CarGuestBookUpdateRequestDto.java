package kr.seoulautogallery.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarGuestBookUpdateRequestDto {
    private String carinfo;
    private String guestname;
    private String phonenum;
    private String email;
    private String content;

    @Builder
    public CarGuestBookUpdateRequestDto(String carinfo, String guestname, String phonenum, String email, String content ) {
        this.carinfo = carinfo;
        this.guestname = guestname;
        this.phonenum = phonenum;
        this.email = email;
        this.content = content;
    }
}
