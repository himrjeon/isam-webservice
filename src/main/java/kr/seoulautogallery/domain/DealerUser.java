package kr.seoulautogallery.domain;

import kr.seoulautogallery.domain.user.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
public class DealerUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String userid;

    @Column
    private String password;

    @Column
    private String picture;

    @Column
    private String shopname;

    @Column
    private String shopadd;

    @Column
    private String phonenum;

    @Column
    private String shopnum;

    @Column
    private String email;

    @Column
    private String regicheck;

    @Builder
    public DealerUser(Long id, String name, String userid, String password, String picture, String shopname, String shopadd, String phonenum, String shopnum, String email,  String regicheck) {
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
    }

    public void update(String name, String userid, String password, String picture, String shopname, String shopadd, String phonenum, String shopnum, String email,  String regicheck) {
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.shopname = shopname;
        this.shopadd = shopadd;
        this.phonenum = phonenum;
        this.shopnum = shopnum;
        this.email = email;
        this.regicheck = regicheck;
    }

}
