package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.DealerUser;
import kr.seoulautogallery.domain.ImportCars;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DealerUserDto {
    private Long id;
    private String name;
    private String userid;
    private String password;
    private String picture;
    private String shopname;
    private String shopadd;
    private String phonenum;
    private String shopnum;
    private String email;
    private String regicheck;
    private String picturefullpath;

    public DealerUser toEntity(){
        DealerUser build = DealerUser.builder()
                .id(id)
                .name(name)
                .userid(userid)
                .password(password)
                .picture(picture)
                .shopname(shopname)
                .shopadd(shopadd)
                .phonenum(phonenum)
                .shopnum(shopnum)
                .email(email)
                .regicheck(regicheck)
                .build();
        return build;
    }
    @Builder
    public DealerUserDto(Long id, String name, String userid, String password, String picture, String shopname, String shopadd, String phonenum, String shopnum, String email,  String regicheck, String picturefullpath) {
        this.id = id;
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.shopname = shopname;
        this.shopadd = shopadd;
        this.phonenum = phonenum;
        this.shopnum = shopnum;
        this.email = email;
        this.picture = picture;
        this.regicheck = regicheck;
        this.picturefullpath = picturefullpath;
    }

}
