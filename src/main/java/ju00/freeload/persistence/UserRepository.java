package ju00.freeload.persistence;

import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);

    List<UserEntity> findByEmail(String email);

    List<UserEntity> findAllByEmail(String email);

}