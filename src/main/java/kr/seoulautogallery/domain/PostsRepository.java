package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

// JPaRepository<Entity 클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.
// DB레이어 접근자 Dao라고 불리기도 함. entity클래스와 repository는 함께 위치해야한다.
// SpringDataJpa가 제공하지 않는 메소드의 경우 @Query가 가독성이 좋으니 선택해서 사용하면 됨.
// 조회는 querydsl, mybatis 프레임워크를 사용해서 조회하고 등록,수정,삭제의 경우 SpringDataJpa로 사용