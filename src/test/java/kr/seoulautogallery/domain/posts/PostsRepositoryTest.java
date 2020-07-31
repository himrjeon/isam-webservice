package kr.seoulautogallery.domain.posts;

import kr.seoulautogallery.domain.Posts;
import kr.seoulautogallery.domain.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // SpringBootTest 사용의 경우 H2 데이터베이스를 자동으로 실행해줌.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위테스트가 끝날 때 마다 수행되는 메소드 지정. 데이터 침범을 막기 위해 사용
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // postRepository.save는 테이블 posts에 insert/update 쿼리를 실행함. id값이 있으면 업데이트, 없다면 insert 쿼리 실행
        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("hi@cslab.com")
                        .build());

        //when
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate=" + posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
