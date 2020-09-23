package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImportCarsRepository extends JpaRepository<ImportCars, Long> {
        @Override
        List<ImportCars> findAll();

        @Query(nativeQuery = true, value = "SELECT * FROM importcar p ORDER BY p.id DESC LIMIT 6")
        List<ImportCars> findTop6Desc();

        }
