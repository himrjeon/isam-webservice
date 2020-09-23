package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarGuestBookRepository extends JpaRepository<CarGuestBook, Long> {

    @Query("SELECT p FROM CarGuestBook p ORDER BY p.id DESC")
    List<CarGuestBook> findAllDesc();
}
