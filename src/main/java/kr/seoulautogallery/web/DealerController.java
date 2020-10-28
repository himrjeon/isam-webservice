package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.LoginUser;
import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.domain.DealerUser;
import kr.seoulautogallery.domain.DealerUserRepository;
import kr.seoulautogallery.service.DealerUserLoginService;
import kr.seoulautogallery.web.dto.DealerUserDto;
import kr.seoulautogallery.web.dto.ImportCarsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DealerController {

    private final DealerUserLoginService dealerUserLoginService;
    private final DealerUserRepository dealerUserRepository;

    @GetMapping("/signup")
    public String about(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "dealeruserregi";
    }

    @GetMapping("/admin/dealer")
    public String dealerlist(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        List<DealerUserDto> galleryDtoList = dealerUserLoginService.getList();
        model.addAttribute("dealer", galleryDtoList);

        return "admin-dealer";
    }

    @GetMapping("/admin/dealer/detail/{id}")
    public String dealerdetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        DealerUserDto dto = dealerUserLoginService.findById(id);
        model.addAttribute("dealer",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "admin-dealer-detail";
    }

    public String signIn(@RequestBody DealerUserDto dealerUserDto) {
        String userid = dealerUserDto.getUserid();
        String password = dealerUserDto.getPassword();
        System.out.println(userid);
        System.out.println(password);
        DealerUser dealerUser = dealerUserRepository.findUser(userid, password);
        if(dealerUser != null) {
            return "/freeboard";
        }
        return "/";
    }



}
