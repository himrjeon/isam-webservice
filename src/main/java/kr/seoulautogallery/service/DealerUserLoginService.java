package kr.seoulautogallery.service;

import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.domain.DealerUser;
import kr.seoulautogallery.domain.DealerUserRepository;
import kr.seoulautogallery.service.cars.S3Service;
import kr.seoulautogallery.web.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DealerUserLoginService {
    private DealerUserRepository dealerUserRepository;
    private final HttpSession httpSession;
    private S3Service s3Service;

    public void savePost(DealerUserDto dealerUserDto) {
        dealerUserRepository.save(dealerUserDto.toEntity());
    }

    public List<DealerUserDto> getList() {
        List<DealerUser> galleryEntityList = dealerUserRepository.findAll();
        List<DealerUserDto> galleryDtoList = new ArrayList<>();

        for (DealerUser galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    public DealerUserDto findById(Long id) {
        DealerUser entity = dealerUserRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        DealerUserDto dto = convertEntityToDto(entity);

        return dto;
    }

    @Transactional
    public Long update(Long id, DealerUserDto requestDto) {
        DealerUser entity = dealerUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        entity.update(requestDto.getName(), requestDto.getUserid(), requestDto.getPassword(), requestDto.getPicture(), requestDto.getShopname(), requestDto.getShopadd(), requestDto.getPhonenum(), requestDto.getShopnum(), requestDto.getEmail(), requestDto.getRegicheck());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        DealerUser notice = dealerUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        dealerUserRepository.delete(notice);
    }

    @Transactional
    public void signIn(DealerUserDto dealerUserDto) {
        String userid = dealerUserDto.getUserid();
        String password = dealerUserDto.getPassword();
        DealerUser dealerUser = dealerUserRepository.findUser(userid, password);
        if(dealerUser != null) {
            httpSession.setAttribute("user1", dealerUser);
        }

    }


    private DealerUserDto convertEntityToDto(DealerUser galleryEntity) {
        return DealerUserDto.builder()
                .id(galleryEntity.getId())
                .name(galleryEntity.getName())
                .userid(galleryEntity.getUserid())
                .password(galleryEntity.getPassword())
                .picture(galleryEntity.getPicture())
                .shopname(galleryEntity.getShopname())
                .shopadd(galleryEntity.getShopadd())
                .phonenum(galleryEntity.getPhonenum())
                .shopnum(galleryEntity.getShopnum())
                .email(galleryEntity.getEmail())
                .regicheck(galleryEntity.getRegicheck())
                .picturefullpath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getPicture())
                .build();
    }

}
