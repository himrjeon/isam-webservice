package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.LoginUser;
import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.service.posts.PostsService;
import kr.seoulautogallery.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/indexx")
    public String index(Model model, @LoginUser SessionUser user) {  //model은 서버템플릿엔진에서 사용할 수 있는 객체 저장 여기서는 결과는 posts로 index.mustache에 전달
        model.addAttribute("posts", postsService.findAllDesc());
        // 기존에 httpSesstion.getAttribute("user")로 가져오던 세션 정보 값이 개선됨.
        // 이제는 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있게 됨.

        // 로그인유저 세션 추가 SessionUser user = (SessionUser) httpSession.getAttribute("user");
        // 앞서 작성된 customOAuth2UserService에서 로그인 성공시 세션이 sessionuser를 저장하도록 구성.
        // 즉 로그인 성공시 httpSession.getAttribute에서 값을 가져올 수 있음.

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        // 세션에 저장된 값이 있을 때만 model에 userName으로 등록함. 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니
        // 로그인 버튼이 보이게 된다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

    @GetMapping("/")
    public String indexx(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }
        return "indextest";
    }


    @GetMapping("/about")
    public String about() { return "about"; }

    @GetMapping("/snslogin")
    public String snslogin() { return "snslogin"; }

    @GetMapping("/carprocess")
    public String carprocess() {return "carprocess";}

    @GetMapping("/cometous")
    public String cometous() {return "cometous";}

    @GetMapping("/financial")
    public String financial() {return "financial";}

}
