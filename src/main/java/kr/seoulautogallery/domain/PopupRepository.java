package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PopupRepository extends JpaRepository<Popup, Long> {
    @Override
    List<Popup> findAll();
}