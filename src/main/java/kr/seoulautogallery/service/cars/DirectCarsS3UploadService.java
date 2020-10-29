package kr.seoulautogallery.service.cars;

import kr.seoulautogallery.domain.DirectCars;
import kr.seoulautogallery.domain.DirectCarsRepository;
import kr.seoulautogallery.domain.UsedCars;
import kr.seoulautogallery.web.dto.DirectCarsDto;
import kr.seoulautogallery.web.dto.UsedCarsDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DirectCarsS3UploadService {
    private DirectCarsRepository directCarsRepository;
    private S3Service s3Service;

    public void savePost(DirectCarsDto directCarsDto) {
        directCarsRepository.save(directCarsDto.toEntity());
    }

    @Transactional
    public List<DirectCarsDto> getBoardList(Pageable pageable) {
        Page<DirectCars> galleryEntityList = directCarsRepository.findAll(pageable);
        List<DirectCarsDto> galleryDtoList = new ArrayList<>();;

        for (DirectCars galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;

    }

    public List<DirectCarsDto> getList() {
        List<DirectCars> galleryEntityList = directCarsRepository.findAllDesc();
        List<DirectCarsDto> galleryDtoList = new ArrayList<>();

        for (DirectCars galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    public DirectCarsDto findById(Long id) {
        DirectCars entity = directCarsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        DirectCarsDto dto = convertEntityToDto(entity);

        return dto;
    }

    @Transactional
    public Long update(Long id, DirectCarsDto requestDto) {
        DirectCars entity = directCarsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        entity.update(requestDto.getTitle(), requestDto.getCarsalecheck(), requestDto.getSubcontent(), requestDto.getFilePath(), requestDto.getFilePath2(), requestDto.getFilePath3(), requestDto.getFilePath4(), requestDto.getFilePath5(), requestDto.getFilePath6(), requestDto.getFilePath7(), requestDto.getFilePath8(), requestDto.getFilePath9(), requestDto.getFilePath10(), requestDto.getFilePath11(), requestDto.getFilePath12(), requestDto.getFilePath13(), requestDto.getFilePath14(), requestDto.getFilePath15(), requestDto.getFilePath16(), requestDto.getFilePath17(), requestDto.getFilePath18(), requestDto.getFilePath19(), requestDto.getFilePath20(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        DirectCars notice = directCarsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        directCarsRepository.delete(notice);
    }

    @Transactional(readOnly = true)
    public List<DirectCarsDto> findTop6Desc() {
        List<DirectCars> galleryEntityList = directCarsRepository.findTop6Desc();
        List<DirectCarsDto> galleryDtoList = new ArrayList<>();

        for (DirectCars galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    private DirectCarsDto convertEntityToDto(DirectCars galleryEntity) {
        return DirectCarsDto.builder()
                .id(galleryEntity.getId())
                .title(galleryEntity.getTitle())
                .carsalecheck(galleryEntity.getCarsalecheck())
                .subcontent(galleryEntity.getSubcontent())
                .content(galleryEntity.getContent())
                .createdDate(galleryEntity.getCreatedDate())
                .filePath(galleryEntity.getFilePath())
                .imgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
                .filePath2(galleryEntity.getFilePath2())
                .imgFullPath2("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath2())
                .filePath3(galleryEntity.getFilePath3())
                .imgFullPath3("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath3())
                .filePath4(galleryEntity.getFilePath4())
                .imgFullPath4("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath4())
                .filePath5(galleryEntity.getFilePath5())
                .imgFullPath5("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath5())
                .filePath6(galleryEntity.getFilePath6())
                .imgFullPath6("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath6())
                .filePath7(galleryEntity.getFilePath7())
                .imgFullPath7("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath7())
                .filePath8(galleryEntity.getFilePath8())
                .imgFullPath8("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath8())
                .filePath9(galleryEntity.getFilePath9())
                .imgFullPath9("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath9())
                .filePath10(galleryEntity.getFilePath10())
                .imgFullPath10("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath10())
                .filePath11(galleryEntity.getFilePath11())
                .imgFullPath11("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath11())
                .filePath12(galleryEntity.getFilePath12())
                .imgFullPath12("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath12())
                .filePath13(galleryEntity.getFilePath13())
                .imgFullPath13("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath13())
                .filePath14(galleryEntity.getFilePath14())
                .imgFullPath14("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath14())
                .filePath15(galleryEntity.getFilePath15())
                .imgFullPath15("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath15())
                .filePath16(galleryEntity.getFilePath16())
                .imgFullPath16("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath16())
                .filePath17(galleryEntity.getFilePath17())
                .imgFullPath17("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath17())
                .filePath18(galleryEntity.getFilePath18())
                .imgFullPath18("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath18())
                .filePath19(galleryEntity.getFilePath19())
                .imgFullPath19("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath19())
                .filePath20(galleryEntity.getFilePath20())
                .imgFullPath20("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath20())
                .build();
    }

}
