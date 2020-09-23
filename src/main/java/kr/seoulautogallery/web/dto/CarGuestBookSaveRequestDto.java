package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.CarGuestBook;
import kr.seoulautogallery.domain.GuestBook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarGuestBookSaveRequestDto {
    private String carinfo;
    private String guestname;
    private String phonenum;
    private String email;
    private String content;

    @Builder
    public CarGuestBookSaveRequestDto(String carinfo, String guestname, String phonenum, String email, String content) {
        this.carinfo = carinfo;
        this.guestname = guestname;
        this.phonenum = phonenum;
        this.email = email;
        this.content = content;
    }

    public CarGuestBook toEntity() {
        return CarGuestBook.builder()
                .carinfo(carinfo)
                .guestname(guestname)
                .phonenum(phonenum)
                .email(email)
                .content(content)
                .build();
    }
}
