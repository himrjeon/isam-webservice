package kr.seoulautogallery.web.dto;

import kr.seoulautogallery.domain.ImportCars;
import kr.seoulautogallery.domain.Popup;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PopupDto {
    private Long id;
    private String title;
    private String linkPath;
    private String filePath;
    private String imgFullPath;

    public Popup toEntity(){
        Popup build = Popup.builder()
                .id(id)
                .title(title)
                .linkPath(linkPath)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public PopupDto(Long id, String title, String linkPath, String filePath, String imgFullPath) {
        this.id = id;
        this.title = title;
        this.linkPath = linkPath;
        this.filePath = filePath;
        this.imgFullPath = imgFullPath;
    }
}
