package kr.seoulautogallery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealerUserRepository extends JpaRepository<DealerUser, Long> {
    @Override
    List<DealerUser> findAll();

    @Query("SELECT p FROM DealerUser p ORDER BY p.id DESC")
    List<DealerUser> findAllDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM DealerUser p ORDER BY p.id DESC LIMIT 6")
    List<DealerUser> findTop6Desc();

    @Query("select m from DealerUser m where userid = :userid and password = :password and regicheck = 1")
    DealerUser findUser(String userid, String password);

}
