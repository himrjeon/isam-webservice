package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.GuestBook;
import kr.seoulautogallery.domain.News;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GuestBookSaveRequestDto {

    private String guestname;
    private String phonenum;
    private String email;
    private String content;
    private String nowcar;
    private String salecheck;

    @Builder
    public GuestBookSaveRequestDto(String guestname, String phonenum, String email, String content, String nowcar, String salecheck) {
        this.guestname = guestname;
        this.phonenum = phonenum;
        this.email = email;
        this.content = content;
        this.nowcar = nowcar;
        this.salecheck = salecheck;
    }

    public GuestBook toEntity() {
        return GuestBook.builder()
                .guestname(guestname)
                .phonenum(phonenum)
                .email(email)
                .content(content)
                .nowcar(nowcar)
                .salecheck(salecheck)
                .build();
    }
}
