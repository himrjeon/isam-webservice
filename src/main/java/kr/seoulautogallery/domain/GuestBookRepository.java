package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

    @Query("SELECT p FROM GuestBook p ORDER BY p.id DESC")
    List<GuestBook> findAllDesc();
}