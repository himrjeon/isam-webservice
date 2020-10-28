package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.ShowRoom;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ShowRoomDto {
    private Long id;
    private String title;
    private String carsalecheck;
    private String subcontent;
    private String content;
    private LocalDateTime createdDate;
    private String filePath;
    private String filePath2;
    private String filePath3;
    private String filePath4;
    private String filePath5;
    private String filePath6;
    private String filePath7;
    private String filePath8;
    private String filePath9;
    private String filePath10;
    private String filePath11;
    private String filePath12;
    private String filePath13;
    private String filePath14;
    private String filePath15;
    private String filePath16;
    private String filePath17;
    private String filePath18;
    private String filePath19;
    private String filePath20;
    private String imgFullPath;
    private String imgFullPath2;
    private String imgFullPath3;
    private String imgFullPath4;
    private String imgFullPath5;
    private String imgFullPath6;
    private String imgFullPath7;
    private String imgFullPath8;
    private String imgFullPath9;
    private String imgFullPath10;
    private String imgFullPath11;
    private String imgFullPath12;
    private String imgFullPath13;
    private String imgFullPath14;
    private String imgFullPath15;
    private String imgFullPath16;
    private String imgFullPath17;
    private String imgFullPath18;
    private String imgFullPath19;
    private String imgFullPath20;

    public ShowRoom toEntity(){
        ShowRoom build = ShowRoom.builder()
                .id(id)
                .title(title)
                .carsalecheck(carsalecheck)
                .subcontent(subcontent)
                .content(content)
                .filePath(filePath)
                .filePath2(filePath2)
                .filePath3(filePath3)
                .filePath4(filePath4)
                .filePath5(filePath5)
                .filePath6(filePath6)
                .filePath7(filePath7)
                .filePath8(filePath8)
                .filePath9(filePath9)
                .filePath10(filePath10)
                .filePath11(filePath11)
                .filePath12(filePath12)
                .filePath13(filePath13)
                .filePath14(filePath14)
                .filePath15(filePath15)
                .filePath16(filePath16)
                .filePath17(filePath17)
                .filePath18(filePath18)
                .filePath19(filePath19)
                .filePath20(filePath20)
                .build();
        return build;
    }

    @Builder
    public ShowRoomDto(Long id, LocalDateTime createdDate, String title, String carsalecheck, String subcontent, String filePath, String filePath2, String filePath3, String filePath4, String filePath5, String filePath6, String filePath7, String filePath8, String filePath9, String filePath10, String filePath11, String filePath12, String filePath13, String filePath14, String filePath15, String filePath16, String filePath17, String filePath18, String filePath19, String filePath20, String content, String imgFullPath,
                         String imgFullPath2, String imgFullPath3, String imgFullPath4, String imgFullPath5, String imgFullPath6, String imgFullPath7, String imgFullPath8, String imgFullPath9, String imgFullPath10, String imgFullPath11, String imgFullPath12, String imgFullPath13, String imgFullPath14, String imgFullPath15, String imgFullPath16, String imgFullPath17, String imgFullPath18, String imgFullPath19, String imgFullPath20) {
        this.id = id;
        this.title = title;
        this.carsalecheck = carsalecheck;
        this.subcontent = subcontent;
        this.content = content;
        this.createdDate = createdDate;
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
        this.imgFullPath = imgFullPath;
        this.imgFullPath2 = imgFullPath2;
        this.imgFullPath3 = imgFullPath3;
        this.imgFullPath4 = imgFullPath4;
        this.imgFullPath5 = imgFullPath5;
        this.imgFullPath6 = imgFullPath6;
        this.imgFullPath7 = imgFullPath7;
        this.imgFullPath8 = imgFullPath8;
        this.imgFullPath9 = imgFullPath9;
        this.imgFullPath10 = imgFullPath10;
        this.imgFullPath11 = imgFullPath11;
        this.imgFullPath12 = imgFullPath12;
        this.imgFullPath13 = imgFullPath13;
        this.imgFullPath14 = imgFullPath14;
        this.imgFullPath15 = imgFullPath15;
        this.imgFullPath16 = imgFullPath16;
        this.imgFullPath17 = imgFullPath17;
        this.imgFullPath18 = imgFullPath18;
        this.imgFullPath19 = imgFullPath19;
        this.imgFullPath20 = imgFullPath20;
    }
}
