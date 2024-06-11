package ju00.freeload.persistence;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import ju00.freeload.model.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface WishRepository extends JpaRepository<WishEntity, Long> {
    //List<WishEntity> findSvarCdByEmail(String email);
    List<WishEntity> findByEmail(String email);

    @Query("SELECT w.restEntity.svarCd FROM WishEntity w WHERE w.email = :email")
    List<String> findSvarCdByEmail(String email);

//    List<WishEntity> findByUserEntity(UserEntity user);
}

