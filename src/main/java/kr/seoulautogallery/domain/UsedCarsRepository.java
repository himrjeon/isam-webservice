package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsedCarsRepository extends JpaRepository<UsedCars, Long> {
    @Override
    List<UsedCars> findAll();

    @Query("SELECT p FROM UsedCars p ORDER BY p.id DESC")
    List<UsedCars> findAllDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM usedcar p ORDER BY p.id DESC LIMIT 6")
    List<UsedCars> findTop6Desc();

}