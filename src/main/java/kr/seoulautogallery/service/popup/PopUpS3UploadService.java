package kr.seoulautogallery.service.popup;

import kr.seoulautogallery.domain.Notice;
import kr.seoulautogallery.domain.Popup;
import kr.seoulautogallery.domain.PopupRepository;
import kr.seoulautogallery.service.cars.S3Service;
import kr.seoulautogallery.web.dto.NoticeUpdateRequestDto;
import kr.seoulautogallery.web.dto.PopupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PopUpS3UploadService {
    private PopupRepository popupRepository;
    private S3Service s3Service;

    public void savePost(PopupDto popupDto) {
        popupRepository.save(popupDto.toEntity());
    }

    public List<PopupDto> getList() {
        List<Popup> galleryEntityList = popupRepository.findAll();
        List<PopupDto> galleryDtoList = new ArrayList<>();

        for (Popup galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    public PopupDto findById(Long id) {
        Popup entity = popupRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        PopupDto dto = convertEntityToDto(entity);

        return dto;
    }

    @Transactional
    public Long update(Long id, PopupDto requestDto) {
        Popup entity = popupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        entity.update(requestDto.getTitle(), requestDto.getLinkPath(), requestDto.getFilePath());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Popup notice = popupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        popupRepository.delete(notice);
    }


    private PopupDto convertEntityToDto(Popup galleryEntity) {
        return PopupDto.builder()
                .id(galleryEntity.getId())
                .title(galleryEntity.getTitle())
                .linkPath(galleryEntity.getLinkPath())
                .filePath(galleryEntity.getFilePath())
                .imgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
                .build();
    }
}
