package kr.seoulautogallery.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectCarsRepository extends JpaRepository<DirectCars, Long> {
    @Override
    List<DirectCars> findAll();

    @Query("SELECT p FROM DirectCars p ORDER BY p.id DESC")
    List<DirectCars> findAllDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM directcar p ORDER BY p.id DESC LIMIT 6")
    List<DirectCars> findTop6Desc();

    List<DirectCars> findByTitleContaining(String keyword, Pageable pageable);

}