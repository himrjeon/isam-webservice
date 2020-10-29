package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.LoginUser;
import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.domain.DealerUser;
import kr.seoulautogallery.service.cars.S3Service;
import kr.seoulautogallery.service.cars.ImportCarsS3UploadService;
import kr.seoulautogallery.service.cars.ShowRoomS3UploadService;
import kr.seoulautogallery.service.cars.UsedCarsS3UploadService;
import kr.seoulautogallery.web.dto.ImportCarsDto;
import kr.seoulautogallery.web.dto.ShowRoomDto;
import kr.seoulautogallery.web.dto.UsedCarsDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CarsController {

    private final HttpSession httpSession;
    private final S3Service s3Service;
    private final ImportCarsS3UploadService importCarsS3UploadService;
    private final UsedCarsS3UploadService usedCarsS3UploadService;
    private final ShowRoomS3UploadService showRoomS3UploadService;

    @GetMapping("/importcar")
    public String importcar(Model model, @LoginUser SessionUser user, @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        //List<ImportCarsDto> importCarsDtoList = importCarsS3UploadService.getList();
        // List<ImportCarsDto> importCarsDtoList = importCarsS3UploadService.findTop50Desc();
        List<ImportCarsDto> importCarsDtoList = importCarsS3UploadService.getBoardList(pageable);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("galleryList", importCarsDtoList);

        return "importcar";
    }

    @GetMapping("/importcar/save")
    public String importCarSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "importcar-save";
    }

    @GetMapping("/importcar/detail/{id}")
    public String importCarsDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        ImportCarsDto dto = importCarsS3UploadService.findById(id);
        model.addAttribute("importcar",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "importcar-detail";
    }

    @GetMapping("/importcar/update/{id}")
    public String importCarsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        ImportCarsDto dto = importCarsS3UploadService.findById(id);
        model.addAttribute("importcar",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }


        return "importcar-update";
    }

    @PostMapping("/importcar/upload")
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

        return "importcar";
    }

    @GetMapping("/usedcar")
    public String usedCar(Model model, @LoginUser SessionUser user,  @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }
        List<UsedCarsDto> usedCarsDtoList = usedCarsS3UploadService.getBoardList(pageable);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("galleryList", usedCarsDtoList);

        // List<UsedCarsDto> usedCarsDtoList = usedCarsS3UploadService.getList();
        // model.addAttribute("galleryList", usedCarsDtoList);

        return "usedcar";
    }

    @GetMapping("/usedcar/save")
    public String usedCarSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "usedcar-save";
    }

    @GetMapping("/usedcar/detail/{id}")
    public String usedCarsDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        UsedCarsDto dto = usedCarsS3UploadService.findById(id);
        model.addAttribute("usedcar",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "usedcar-detail";
    }

    @PostMapping("/usedcar/upload")
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

        return "usedcar";
    }

    @GetMapping("/usedcar/update/{id}")
    public String usedCarsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        UsedCarsDto dto = usedCarsS3UploadService.findById(id);
        model.addAttribute("usedcar",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "usedcar-update";
    }

    @GetMapping("/showroom")
    public String showroom(Model model, @LoginUser SessionUser user, @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        List<ShowRoomDto> showRoomDtoList = showRoomS3UploadService.getBoardList(pageable);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("galleryList", showRoomDtoList);


        //List<ImportCarsDto> importCarsDtoList = importCarsS3UploadService.getList();
        // List<ShowRoomDto> showRoomDtoList = showRoomS3UploadService.getList();
        // model.addAttribute("galleryList", showRoomDtoList);

        return "showroom";
    }


}
