package kr.seoulautogallery.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;

@Getter
@NoArgsConstructor
public class GuestBookUpdateRequestDto {
    private String guestname;
    private String phonenum;
    private String email;
    private String content;
    private String nowcar;
    private String salecheck;

    @Builder
    public GuestBookUpdateRequestDto(String guestname, String phonenum, String email, String content, String nowcar, String salecheck) {
        this.guestname = guestname;
        this.phonenum = phonenum;
        this.email = email;
        this.content = content;
        this.nowcar = nowcar;
        this.salecheck = salecheck;
    }
}
