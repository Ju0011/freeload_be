package ju00.freeload.persistence;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import ju00.freeload.model.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface WishRepository extends JpaRepository<WishEntity, Long> {
    //List<WishEntity> findSvarCdByEmail(String email);
    List<WishEntity> findByEmail(String email);

    @Query("SELECT w.restEntity.svarCd FROM WishEntity w WHERE w.email = :email")
    List<String> findSvarCdByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM WishEntity w WHERE w.email = :email AND w.restEntity.svarCd = :svarCd")
    void deleteByEmailAndSvarCd(@Param("email") String email, @Param("svarCd") String svarCd);
}

