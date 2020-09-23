package kr.seoulautogallery.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "usedcar")
public class UsedCars extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column
    private String caryear;

    @Column
    private String cardistance;

    @Column
    private String carpower;

    @Column
    private String cartransmission;

    @Column
    private String carcolor;

    @Column
    private String carmanufacturer;

    @Column
    private String carmodel;

    @Column
    private String carmodeldetail;

    @Column
    private String cartrimdetail;

    @Column
    private String carsalecheck;

    @Column
    private String subcontent;

    @Column
    private String carfuel;

    @Column
    private String cartrim;

    @Column
    private String cartractor;

    @Column
    private String carprice;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Column(columnDefinition = "TEXT")
    private String filePath2;

    @Column(columnDefinition = "TEXT")
    private String filePath3;

    @Column(columnDefinition = "TEXT")
    private String filePath4;

    @Column(columnDefinition = "TEXT")
    private String filePath5;

    @Column(columnDefinition = "TEXT")
    private String filePath6;

    @Column(columnDefinition = "TEXT")
    private String filePath7;

    @Column(columnDefinition = "TEXT")
    private String filePath8;

    @Column(columnDefinition = "TEXT")
    private String filePath9;

    @Column(columnDefinition = "TEXT")
    private String filePath10;

    @Column(columnDefinition = "TEXT")
    private String filePath11;

    @Column(columnDefinition = "TEXT")
    private String filePath12;

    @Column(columnDefinition = "TEXT")
    private String filePath13;

    @Column(columnDefinition = "TEXT")
    private String filePath14;

    @Column(columnDefinition = "TEXT")
    private String filePath15;

    @Column(columnDefinition = "TEXT")
    private String filePath16;

    @Column(columnDefinition = "TEXT")
    private String filePath17;

    @Column(columnDefinition = "TEXT")
    private String filePath18;

    @Column(columnDefinition = "TEXT")
    private String filePath19;

    @Column(columnDefinition = "TEXT")
    private String filePath20;

    @Builder
    public UsedCars(Long id, String title, String caryear, String cardistance, String carprice, String carpower, String cartransmission, String carcolor, String carmanufacturer, String carmodel, String carfuel, String cartrim, String cartractor, String carmodeldetail, String cartrimdetail, String carsalecheck, String subcontent, String filePath, String filePath2, String filePath3, String filePath4, String filePath5, String filePath6, String filePath7, String filePath8, String filePath9, String filePath10, String filePath11, String filePath12, String filePath13, String filePath14, String filePath15, String filePath16, String filePath17, String filePath18, String filePath19, String filePath20, String content) {
        this.id = id;
        this.title = title;
        this.caryear = caryear;
        this.cardistance = cardistance;
        this.carpower = carpower;
        this.cartransmission = cartransmission;
        this.carcolor = carcolor;
        this.carmanufacturer = carmanufacturer;
        this.carmodel = carmodel;
        this.carfuel = carfuel;
        this.cartrim = cartrim;
        this.cartractor = cartractor;
        this.carprice = carprice;
        this.carmodeldetail = carmodeldetail;
        this.cartrimdetail = cartrimdetail;
        this.carsalecheck = carsalecheck;
        this.subcontent = subcontent;
        this.content = content;
        this.filePath = filePath;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
        this.filePath4 = filePath4;
        this.filePath5 = filePath5;
        this.filePath6 = filePath6;
        this.filePath7 = filePath7;
        this.filePath8 = filePath8;
        this.filePath9 = filePath9;
        this.filePath10 = filePath10;
        this.filePath11 = filePath11;
        this.filePath12 = filePath12;
        this.filePath13 = filePath13;
        this.filePath14 = filePath14;
        this.filePath15 = filePath15;
        this.filePath16 = filePath16;
        this.filePath17 = filePath17;
        this.filePath18 = filePath18;
        this.filePath19 = filePath19;
        this.filePath20 = filePath20;
    }
}
