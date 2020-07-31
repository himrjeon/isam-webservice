package kr.seoulautogallery.web;

import kr.seoulautogallery.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 테스트 진행시 Junit 내장된 실행자 외에 다른 실행자 실행 연결자역할
@WebMvcTest(controllers = HelloController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    }
) // Web에 집중할 수 있는 어노테이션. 선언 경우 컨트롤러 사용 가능.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받음.
    private MockMvc mvc; // 웹API 테스트시 사용. HTTP, GET, POST 등 API 테스트 가능

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform 결과 검증 상태 검증.
                .andExpect(content().string(hello)); // m,vc.perform 결과 검증.
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name) // API 테스트 요청 파라미터 설정 String만 허용 그 외의 경우 문자열로 변경해야함.
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        // jsonPath의 경우 json 응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명 명시.



    }
}
