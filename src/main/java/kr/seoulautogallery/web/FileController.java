package kr.seoulautogallery.web;

import kr.seoulautogallery.service.cars.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class FileController {
    private S3Service s3Service;

    @PostMapping("/file")
    public ResponseEntity<?> handleImageUpload(@RequestParam("file") MultipartFile file) {
        String fileName;
        try {
            if (file.isEmpty()) {
                return new ResponseEntity("please select a file!", HttpStatus.OK);
            }
            fileName = s3Service.saveUploadedFiles(file);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(fileName);
    }
}
