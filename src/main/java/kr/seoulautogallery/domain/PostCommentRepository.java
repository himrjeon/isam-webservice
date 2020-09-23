package kr.seoulautogallery.domain;

import kr.seoulautogallery.web.dto.PostsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

    @Query("SELECT p FROM PostComment p ORDER BY p.id DESC")
    List<PostComment> findAllDesc();

    @Query("SELECT p FROM PostComment p WHERE p.posts= :#{#id} ORDER BY p.createdDate DESC")
    List<PostComment> findALLByPost(@Param("id") Posts posts);
}
