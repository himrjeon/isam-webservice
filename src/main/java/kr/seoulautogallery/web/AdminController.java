package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.LoginUser;
import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.service.cars.S3Service;
import kr.seoulautogallery.service.cars.ImportCarsS3UploadService;
import kr.seoulautogallery.service.cars.UsedCarsS3UploadService;
import kr.seoulautogallery.service.popup.PopUpS3UploadService;
import kr.seoulautogallery.service.posts.*;
import kr.seoulautogallery.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final PopUpS3UploadService popUpS3UploadService;
    private final NoticeService noticeService;
    private final NewsService newsServices;
    private final HttpSession httpSession;
    private final ImportCarsS3UploadService importCarsS3UploadService;
    private final UsedCarsS3UploadService usedCarsS3UploadService;
    private final S3Service s3Service;
    private final GuestBookService guestBookService;
    private final CarGuestBookService carGuestBookService;

    @GetMapping("/admin")
    public String admin(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin";
    }

    @GetMapping("/admin/importcar")
    public String importcar(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        List<ImportCarsDto> importCarsDtoList = importCarsS3UploadService.getList();
        model.addAttribute("galleryList", importCarsDtoList);

        return "admin-importcar";
    }

    @GetMapping("/admin/usedcar")
    public String usedcar(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        List<UsedCarsDto> usedCarsDtoList = usedCarsS3UploadService.getList();
        model.addAttribute("galleryList", usedCarsDtoList);

        return "admin-usedcar";
    }



    @GetMapping("/admin/notice")
    public String notice(Model model, @LoginUser SessionUser user) {
        model.addAttribute("notice", noticeService.findAllDesc());
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin-notice";
    }

    @GetMapping("/admin/news")
    public String newsboard(Model model, @LoginUser SessionUser user) {
        model.addAttribute("news", newsServices.findAllDesc());

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin-news";
    }

    @GetMapping("/admin/contactus")
    public String adminGuestbook(Model model, @LoginUser SessionUser user) {
        model.addAttribute("guestbook", guestBookService.findAllDesc());

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin-contactus";
    }

    @GetMapping("/admin/contactus/detail/{id}")
    public String adminGuestBookDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        GuestBookResponseDto dto = guestBookService.findById(id);
        model.addAttribute("guestbook",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "admin-contactus-detail";
    }

    @GetMapping("/admin/carcontact")
    public String adminCarGuestbook(Model model, @LoginUser SessionUser user) {
        model.addAttribute("guestbook", carGuestBookService.findAllDesc());

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin-carcontact";
    }

    @GetMapping("/admin/carcontact/detail/{id}")
    public String adminCarGuestBookDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        CarGuestBookResponseDto dto = carGuestBookService.findById(id);
        model.addAttribute("guestbook",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "admin-carcontact-detail";
    }

    @GetMapping("/admin/popup")
    public String adminpopup(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        List<PopupDto> popupDtoList = popUpS3UploadService.getList();
        model.addAttribute("galleryList", popupDtoList);

        return "admin-popup";
    }

    @GetMapping("/admin/popup/save")
    public String adminpopSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "admin-popup-save";
    }

    @GetMapping("/admin/popup/update/{id}")
    public String popupDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PopupDto dto = popUpS3UploadService.findById(id);
        model.addAttribute("popup",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "admin-popup-update";
    }

    @GetMapping("/event/{id}")
    public String eventpop(@PathVariable Long id, Model model) {
        PopupDto dto = popUpS3UploadService.findById(id);
        model.addAttribute("popup",dto);

        return "event_01";
    }


}
