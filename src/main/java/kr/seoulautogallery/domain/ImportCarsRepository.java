package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImportCarsRepository extends JpaRepository<ImportCars, Long> {
        @Override
        List<ImportCars> findAll();

        @Query("SELECT p FROM ImportCars p ORDER BY p.id DESC")
        List<ImportCars> findAllDesc();

        @Query(nativeQuery = true, value = "SELECT * FROM importcar p ORDER BY p.id DESC LIMIT 6")
        List<ImportCars> findTop6Desc();

        @Query(nativeQuery = true, value = "SELECT * FROM importcar p ORDER BY p.id DESC LIMIT 50")
        List<ImportCars> findTop50Desc();

        List<ImportCars> findByTitleContaining(String keyword);

        }
