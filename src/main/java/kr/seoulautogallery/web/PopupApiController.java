package kr.seoulautogallery.web;

import kr.seoulautogallery.service.cars.S3Service;
import kr.seoulautogallery.service.popup.PopUpS3UploadService;

import kr.seoulautogallery.web.dto.NoticeUpdateRequestDto;
import kr.seoulautogallery.web.dto.PopupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PopupApiController {
    private final S3Service s3Service;
    private final PopUpS3UploadService popUpS3UploadService;

    @PostMapping("/api/v2/popsave")
    @ResponseBody
    public String upload(PopupDto popupDto, MultipartFile file) throws IOException {
        String imgPath = s3Service.upload(popupDto.getFilePath(), file);
        popupDto.setFilePath(imgPath);
        popUpS3UploadService.savePost(popupDto);

        return "admin-popup";
    }

    @PostMapping("/api/v2/popup/{id}")
    public Long update(@PathVariable Long id, MultipartFile file, @ModelAttribute PopupDto popupDto) throws IOException {
        String imgPath = s3Service.upload(popupDto.getFilePath(), file);
        popupDto.setFilePath(imgPath);

        return popUpS3UploadService.update(id, popupDto);
    }

    @DeleteMapping("/api/v2/popup/delete/{id}")
    public Long delete(@PathVariable Long id) {
        popUpS3UploadService.delete(id);
        return id;
    }



}
