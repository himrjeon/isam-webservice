package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.LoginUser;
import kr.seoulautogallery.config.auth.dto.SessionUser;
import kr.seoulautogallery.domain.DealerUser;
import kr.seoulautogallery.domain.Posts;
import kr.seoulautogallery.domain.PostsRepository;
import kr.seoulautogallery.service.posts.NewsService;
import kr.seoulautogallery.service.posts.NoticeService;
import kr.seoulautogallery.service.posts.PostCommentService;
import kr.seoulautogallery.service.posts.PostsService;
import kr.seoulautogallery.web.dto.NewsResponseDto;
import kr.seoulautogallery.web.dto.NoticeResponseDto;
import kr.seoulautogallery.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final HttpSession httpSession;
    private final PostsService postsService;
    private final NewsService newsServices;
    private final NoticeService noticeService;
    private final PostCommentService postCommentService;
    private final PostsRepository postsRepository;

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        // 댓글 불러오기
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        model.addAttribute("comment",postCommentService.findALLByPost(entity));

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "posts-update";
    }

    @GetMapping("/posts/detail/{id}")
    public String postsDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        // 댓글 불러오기
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        model.addAttribute("comment",postCommentService.findALLByPost(entity));

        String writeUser = dto.getAuthor();

        if(user != null) {
            model.addAttribute("uName", user.getName());
            if(writeUser.equals(user.getName())) {
                model.addAttribute("writeUser", writeUser);
            }
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
            if(writeUser.equals(user.getName())) {
                model.addAttribute("writeUser", writeUser);
            }
        }


        return "posts-detail";
    }


    @GetMapping("/freeboard")
    public String freeboard(Model model, @LoginUser SessionUser user) {  //model은 서버템플릿엔진에서 사용할 수 있는 객체 저장 여기서는 결과는 posts로 index.mustache에 전달
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

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "freeboard";
    }

    @GetMapping("/news")
    public String newsboard(Model model, @LoginUser SessionUser user) {  //model은 서버템플릿엔진에서 사용할 수 있는 객체 저장 여기서는 결과는 posts로 index.mustache에 전달
        model.addAttribute("news", newsServices.findAllDesc());
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

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "news";
    }

    @GetMapping("/news/save")
    public String newsSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

            return "news-save";
    }

    @GetMapping("/news/update/{id}")
    public String newsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        NewsResponseDto dto = newsServices.findById(id);
        model.addAttribute("news",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "news-update";
    }

    @GetMapping("/news/detail/{id}")
    public String newsDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        NewsResponseDto dto = newsServices.findById(id);
        model.addAttribute("news",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "news-detail";
    }

    @GetMapping("/notice")
    public String notice(Model model, @LoginUser SessionUser user) {  //model은 서버템플릿엔진에서 사용할 수 있는 객체 저장 여기서는 결과는 posts로 index.mustache에 전달
        model.addAttribute("notice", noticeService.findAllDesc());
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

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }


        return "notice";
    }

    @GetMapping("/notice/save")
    public String noticeSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "notice-save";
    }

    @GetMapping("/notice/update/{id}")
    public String noticeUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        NoticeResponseDto dto = noticeService.findById(id);
        model.addAttribute("notice",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "notice-update";
    }

    @GetMapping("/notice/detail/{id}")
    public String noticeDetail(@PathVariable Long id, Model model, @LoginUser SessionUser user) {

        NoticeResponseDto dto = noticeService.findById(id);
        model.addAttribute("notice",dto);

        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }


        return "notice-detail";
    }

    @GetMapping("/contactus")
    public String contactus(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("uName", user.getName());
        }

        DealerUser dealerUser = (DealerUser)httpSession.getAttribute("user1");
        if(dealerUser != null) {
            model.addAttribute("dName", dealerUser.getName());
        }

        return "contactus";
    }
}
