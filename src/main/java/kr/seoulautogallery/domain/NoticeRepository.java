package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

        import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT p FROM Notice p ORDER BY p.id DESC")
    List<Notice> findAllDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM notice p ORDER BY p.id DESC LIMIT 3")
    List<Notice> findTop3Desc();
}
