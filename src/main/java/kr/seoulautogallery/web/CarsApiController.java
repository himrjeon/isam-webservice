package kr.seoulautogallery.web;

import kr.seoulautogallery.service.cars.*;
import kr.seoulautogallery.web.dto.DirectCarsDto;
import kr.seoulautogallery.web.dto.ImportCarsDto;
import kr.seoulautogallery.web.dto.ShowRoomDto;
import kr.seoulautogallery.web.dto.UsedCarsDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class CarsApiController {

    private final S3Service s3Service;
    private final ImportCarsS3UploadService importCarsS3UploadService;
    private final UsedCarsS3UploadService usedCarsS3UploadService;
    private final DirectCarsS3UploadService directCarsS3UploadService;
    private final ShowRoomS3UploadService showRoomS3UploadService;

    @PostMapping("/api/v2/importcars")
    @ResponseBody
    public String upload(ImportCarsDto importCarsDto, MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20) throws IOException {
        String imgPath = s3Service.upload(importCarsDto.getFilePath(), file);
        importCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(importCarsDto.getFilePath2(), file2);
        importCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(importCarsDto.getFilePath3(), file3);
        importCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(importCarsDto.getFilePath4(), file4);
        importCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(importCarsDto.getFilePath5(), file5);
        importCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(importCarsDto.getFilePath6(), file6);
        importCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(importCarsDto.getFilePath7(), file7);
        importCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(importCarsDto.getFilePath8(), file8);
        importCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(importCarsDto.getFilePath9(), file9);
        importCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(importCarsDto.getFilePath10(), file10);
        importCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(importCarsDto.getFilePath11(), file11);
        importCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(importCarsDto.getFilePath12(), file12);
        importCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(importCarsDto.getFilePath13(), file13);
        importCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(importCarsDto.getFilePath14(), file14);
        importCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(importCarsDto.getFilePath15(), file15);
        importCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(importCarsDto.getFilePath16(), file16);
        importCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(importCarsDto.getFilePath17(), file17);
        importCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(importCarsDto.getFilePath18(), file18);
        importCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(importCarsDto.getFilePath19(), file19);
        importCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(importCarsDto.getFilePath20(), file20);
        importCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(importCarsDto.getContent());
        importCarsDto.setContent(sText);
        importCarsS3UploadService.savePost(importCarsDto);

        return "/admin/importcar";
    }

    @PostMapping("/api/v2/importcar/update/{id}")
    public Long importcarupdate(@PathVariable Long id,  MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20, @ModelAttribute ImportCarsDto importCarsDto) throws IOException {
        String imgPath = s3Service.upload(importCarsDto.getFilePath(), file);
        importCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(importCarsDto.getFilePath2(), file2);
        importCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(importCarsDto.getFilePath3(), file3);
        importCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(importCarsDto.getFilePath4(), file4);
        importCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(importCarsDto.getFilePath5(), file5);
        importCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(importCarsDto.getFilePath6(), file6);
        importCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(importCarsDto.getFilePath7(), file7);
        importCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(importCarsDto.getFilePath8(), file8);
        importCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(importCarsDto.getFilePath9(), file9);
        importCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(importCarsDto.getFilePath10(), file10);
        importCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(importCarsDto.getFilePath11(), file11);
        importCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(importCarsDto.getFilePath12(), file12);
        importCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(importCarsDto.getFilePath13(), file13);
        importCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(importCarsDto.getFilePath14(), file14);
        importCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(importCarsDto.getFilePath15(), file15);
        importCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(importCarsDto.getFilePath16(), file16);
        importCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(importCarsDto.getFilePath17(), file17);
        importCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(importCarsDto.getFilePath18(), file18);
        importCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(importCarsDto.getFilePath19(), file19);
        importCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(importCarsDto.getFilePath20(), file20);
        importCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(importCarsDto.getContent());
        importCarsDto.setContent(sText);

        return importCarsS3UploadService.update(id, importCarsDto);
    }

    @DeleteMapping("/api/v2/importcar/delete/{id}")
    public Long importCardelete(@PathVariable Long id) {
        importCarsS3UploadService.delete(id);
        return id;
    }

    @PostMapping("/api/v2/usedcars")
    @ResponseBody
    public String usedCarUpload(UsedCarsDto usedCarsDto, MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20) throws IOException {
        String imgPath = s3Service.upload(usedCarsDto.getFilePath(), file);
        usedCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(usedCarsDto.getFilePath2(), file2);
        usedCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(usedCarsDto.getFilePath3(), file3);
        usedCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(usedCarsDto.getFilePath4(), file4);
        usedCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(usedCarsDto.getFilePath5(), file5);
        usedCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(usedCarsDto.getFilePath6(), file6);
        usedCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(usedCarsDto.getFilePath7(), file7);
        usedCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(usedCarsDto.getFilePath8(), file8);
        usedCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(usedCarsDto.getFilePath9(), file9);
        usedCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(usedCarsDto.getFilePath10(), file10);
        usedCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(usedCarsDto.getFilePath11(), file11);
        usedCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(usedCarsDto.getFilePath12(), file12);
        usedCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(usedCarsDto.getFilePath13(), file13);
        usedCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(usedCarsDto.getFilePath14(), file14);
        usedCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(usedCarsDto.getFilePath15(), file15);
        usedCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(usedCarsDto.getFilePath16(), file16);
        usedCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(usedCarsDto.getFilePath17(), file17);
        usedCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(usedCarsDto.getFilePath18(), file18);
        usedCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(usedCarsDto.getFilePath19(), file19);
        usedCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(usedCarsDto.getFilePath20(), file20);
        usedCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(usedCarsDto.getContent());
        usedCarsDto.setContent(sText);
        usedCarsS3UploadService.savePost(usedCarsDto);

        return "/admin/usedcar";
    }

    @PostMapping("/api/v2/usedcar/update/{id}")
    public Long usedcarupdate(@PathVariable Long id,  MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20, @ModelAttribute UsedCarsDto usedCarsDto) throws IOException {
        String imgPath = s3Service.upload(usedCarsDto.getFilePath(), file);
        usedCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(usedCarsDto.getFilePath2(), file2);
        usedCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(usedCarsDto.getFilePath3(), file3);
        usedCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(usedCarsDto.getFilePath4(), file4);
        usedCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(usedCarsDto.getFilePath5(), file5);
        usedCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(usedCarsDto.getFilePath6(), file6);
        usedCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(usedCarsDto.getFilePath7(), file7);
        usedCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(usedCarsDto.getFilePath8(), file8);
        usedCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(usedCarsDto.getFilePath9(), file9);
        usedCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(usedCarsDto.getFilePath10(), file10);
        usedCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(usedCarsDto.getFilePath11(), file11);
        usedCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(usedCarsDto.getFilePath12(), file12);
        usedCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(usedCarsDto.getFilePath13(), file13);
        usedCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(usedCarsDto.getFilePath14(), file14);
        usedCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(usedCarsDto.getFilePath15(), file15);
        usedCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(usedCarsDto.getFilePath16(), file16);
        usedCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(usedCarsDto.getFilePath17(), file17);
        usedCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(usedCarsDto.getFilePath18(), file18);
        usedCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(usedCarsDto.getFilePath19(), file19);
        usedCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(usedCarsDto.getFilePath20(), file20);
        usedCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(usedCarsDto.getContent());
        usedCarsDto.setContent(sText);

        return usedCarsS3UploadService.update(id, usedCarsDto);
    }

    @DeleteMapping("/api/v2/usedcar/delete/{id}")
    public Long usedCardelete(@PathVariable Long id) {
        usedCarsS3UploadService.delete(id);
        return id;
    }

    @PostMapping("/api/v2/directcar")
    @ResponseBody
    public String directcarupload(DirectCarsDto directCarsDto, MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20) throws IOException {
        String imgPath = s3Service.upload(directCarsDto.getFilePath(), file);
        directCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(directCarsDto.getFilePath2(), file2);
        directCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(directCarsDto.getFilePath3(), file3);
        directCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(directCarsDto.getFilePath4(), file4);
        directCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(directCarsDto.getFilePath5(), file5);
        directCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(directCarsDto.getFilePath6(), file6);
        directCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(directCarsDto.getFilePath7(), file7);
        directCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(directCarsDto.getFilePath8(), file8);
        directCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(directCarsDto.getFilePath9(), file9);
        directCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(directCarsDto.getFilePath10(), file10);
        directCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(directCarsDto.getFilePath11(), file11);
        directCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(directCarsDto.getFilePath12(), file12);
        directCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(directCarsDto.getFilePath13(), file13);
        directCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(directCarsDto.getFilePath14(), file14);
        directCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(directCarsDto.getFilePath15(), file15);
        directCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(directCarsDto.getFilePath16(), file16);
        directCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(directCarsDto.getFilePath17(), file17);
        directCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(directCarsDto.getFilePath18(), file18);
        directCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(directCarsDto.getFilePath19(), file19);
        directCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(directCarsDto.getFilePath20(), file20);
        directCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(directCarsDto.getContent());
        directCarsDto.setContent(sText);
        directCarsS3UploadService.savePost(directCarsDto);

        return "/admin/directcar";
    }

    @PostMapping("/api/v2/directcar/update/{id}")
    public Long directcarupdate(@PathVariable Long id,  MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20, @ModelAttribute DirectCarsDto directCarsDto) throws IOException {
        String imgPath = s3Service.upload(directCarsDto.getFilePath(), file);
        directCarsDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(directCarsDto.getFilePath2(), file2);
        directCarsDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(directCarsDto.getFilePath3(), file3);
        directCarsDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(directCarsDto.getFilePath4(), file4);
        directCarsDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(directCarsDto.getFilePath5(), file5);
        directCarsDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(directCarsDto.getFilePath6(), file6);
        directCarsDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(directCarsDto.getFilePath7(), file7);
        directCarsDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(directCarsDto.getFilePath8(), file8);
        directCarsDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(directCarsDto.getFilePath9(), file9);
        directCarsDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(directCarsDto.getFilePath10(), file10);
        directCarsDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(directCarsDto.getFilePath11(), file11);
        directCarsDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(directCarsDto.getFilePath12(), file12);
        directCarsDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(directCarsDto.getFilePath13(), file13);
        directCarsDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(directCarsDto.getFilePath14(), file14);
        directCarsDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(directCarsDto.getFilePath15(), file15);
        directCarsDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(directCarsDto.getFilePath16(), file16);
        directCarsDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(directCarsDto.getFilePath17(), file17);
        directCarsDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(directCarsDto.getFilePath18(), file18);
        directCarsDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(directCarsDto.getFilePath19(), file19);
        directCarsDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(directCarsDto.getFilePath20(), file20);
        directCarsDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(directCarsDto.getContent());
        directCarsDto.setContent(sText);

        return directCarsS3UploadService.update(id, directCarsDto);
    }

    @DeleteMapping("/api/v2/directcar/delete/{id}")
    public Long directCardelete(@PathVariable Long id) {
        directCarsS3UploadService.delete(id);
        return id;
    }

    @PostMapping("/api/v2/showroom")
    @ResponseBody
    public String showroomupload(ShowRoomDto showRoomDto, MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20) throws IOException {
        String imgPath = s3Service.upload(showRoomDto.getFilePath(), file);
        showRoomDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(showRoomDto.getFilePath2(), file2);
        showRoomDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(showRoomDto.getFilePath3(), file3);
        showRoomDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(showRoomDto.getFilePath4(), file4);
        showRoomDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(showRoomDto.getFilePath5(), file5);
        showRoomDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(showRoomDto.getFilePath6(), file6);
        showRoomDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(showRoomDto.getFilePath7(), file7);
        showRoomDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(showRoomDto.getFilePath8(), file8);
        showRoomDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(showRoomDto.getFilePath9(), file9);
        showRoomDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(showRoomDto.getFilePath10(), file10);
        showRoomDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(showRoomDto.getFilePath11(), file11);
        showRoomDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(showRoomDto.getFilePath12(), file12);
        showRoomDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(showRoomDto.getFilePath13(), file13);
        showRoomDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(showRoomDto.getFilePath14(), file14);
        showRoomDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(showRoomDto.getFilePath15(), file15);
        showRoomDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(showRoomDto.getFilePath16(), file16);
        showRoomDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(showRoomDto.getFilePath17(), file17);
        showRoomDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(showRoomDto.getFilePath18(), file18);
        showRoomDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(showRoomDto.getFilePath19(), file19);
        showRoomDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(showRoomDto.getFilePath20(), file20);
        showRoomDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(showRoomDto.getContent());
        showRoomDto.setContent(sText);
        showRoomS3UploadService.savePost(showRoomDto);

        return "/admin/showroom";
    }

    @PostMapping("/api/v2/showroom/update/{id}")
    public Long showroomupdate(@PathVariable Long id,  MultipartFile file, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, MultipartFile file9, MultipartFile file10, MultipartFile file11, MultipartFile file12, MultipartFile file13, MultipartFile file14, MultipartFile file15, MultipartFile file16, MultipartFile file17, MultipartFile file18, MultipartFile file19, MultipartFile file20, @ModelAttribute ShowRoomDto showRoomDto) throws IOException {
        String imgPath = s3Service.upload(showRoomDto.getFilePath(), file);
        showRoomDto.setFilePath(imgPath);
        String imgPath2 = s3Service.upload(showRoomDto.getFilePath2(), file2);
        showRoomDto.setFilePath2(imgPath2);
        String imgPath3 = s3Service.upload(showRoomDto.getFilePath3(), file3);
        showRoomDto.setFilePath3(imgPath3);
        String imgPath4 = s3Service.upload(showRoomDto.getFilePath4(), file4);
        showRoomDto.setFilePath4(imgPath4);
        String imgPath5 = s3Service.upload(showRoomDto.getFilePath5(), file5);
        showRoomDto.setFilePath5(imgPath5);
        String imgPath6 = s3Service.upload(showRoomDto.getFilePath6(), file6);
        showRoomDto.setFilePath6(imgPath6);
        String imgPath7 = s3Service.upload(showRoomDto.getFilePath7(), file7);
        showRoomDto.setFilePath7(imgPath7);
        String imgPath8 = s3Service.upload(showRoomDto.getFilePath8(), file8);
        showRoomDto.setFilePath8(imgPath8);
        String imgPath9 = s3Service.upload(showRoomDto.getFilePath9(), file9);
        showRoomDto.setFilePath9(imgPath9);
        String imgPath10 = s3Service.upload(showRoomDto.getFilePath10(), file10);
        showRoomDto.setFilePath10(imgPath10);
        String imgPath11 = s3Service.upload(showRoomDto.getFilePath11(), file11);
        showRoomDto.setFilePath11(imgPath11);
        String imgPath12 = s3Service.upload(showRoomDto.getFilePath12(), file12);
        showRoomDto.setFilePath12(imgPath12);
        String imgPath13 = s3Service.upload(showRoomDto.getFilePath13(), file13);
        showRoomDto.setFilePath13(imgPath13);
        String imgPath14 = s3Service.upload(showRoomDto.getFilePath14(), file14);
        showRoomDto.setFilePath14(imgPath14);
        String imgPath15 = s3Service.upload(showRoomDto.getFilePath15(), file15);
        showRoomDto.setFilePath15(imgPath15);
        String imgPath16 = s3Service.upload(showRoomDto.getFilePath16(), file16);
        showRoomDto.setFilePath16(imgPath16);
        String imgPath17 = s3Service.upload(showRoomDto.getFilePath17(), file17);
        showRoomDto.setFilePath17(imgPath17);
        String imgPath18 = s3Service.upload(showRoomDto.getFilePath18(), file18);
        showRoomDto.setFilePath18(imgPath18);
        String imgPath19 = s3Service.upload(showRoomDto.getFilePath19(), file19);
        showRoomDto.setFilePath19(imgPath19);
        String imgPath20 = s3Service.upload(showRoomDto.getFilePath20(), file20);
        showRoomDto.setFilePath20(imgPath20);
        String sText = StringEscapeUtils.unescapeHtml3(showRoomDto.getContent());
        showRoomDto.setContent(sText);

        return showRoomS3UploadService.update(id, showRoomDto);
    }

    @DeleteMapping("/api/v2/showroom/delete/{id}")
    public Long showRoomdelete(@PathVariable Long id) {
        showRoomS3UploadService.delete(id);
        return id;
    }

}
