package ju00.freeload.persistence;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface WishRepository extends JpaRepository<WishEntity, Long> {
    List<WishEntity> findByEmail(String email);

    List<WishEntity> findAll();
}

