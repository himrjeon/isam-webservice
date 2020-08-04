package kr.seoulautogallery.config.auth;

import kr.seoulautogallery.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 세큐리티 설정들을 활성화시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                    .authorizeRequests() //URL별 권환 관리를 설정하는 옵션의 시작점, 이게 선언되어야만 antmatcher 옵션을 사용할 수 있다.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // /api/v1/** 주소 가진 api는 user 권한을 가진 사람만 가능하도록 함.
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 권한 관리 대상을 지정하는 옵션. URL, HTTP 메소드별로 관리가 가능. / 등 지정된 URL들은 permitALL() 옵션을 통해 전체 열람 권한을 줌. /
                    .anyRequest().permitAll()// 설정된 값들 이외 나머지 url들을 나타냄. 나머지 url들은 모두 인증된 사용자들에게만 허용 즉 로그인한 사람들을 이야기함.
                .and().logout()
                        .logoutSuccessUrl("/")  // 로그아웃 기능에 대한 여러 설정 진입점. 로그아웃 성공시 /주소로 이동
                .and()
                    .oauth2Login() // Oauth2 로그인 기능에 대한 여러 설정의 진입점.
                        .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당함.
                            .userService(customOAuth2UserService); //소셜 로그인 성공시 후속 조치를 진행할 userservice 인터페이스 구현체 등록, 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시 할 수 있음.
    }
}
