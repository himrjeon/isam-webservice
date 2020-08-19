package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsCommentRepository extends JpaRepository<PostComment, Long> {

    @Query("SELECT p FROM PostComment p ORDER BY p.id DESC")
    List<PostComment> findAllDesc();
}
