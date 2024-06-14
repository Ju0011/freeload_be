package ju00.freeload.persistence;

import ju00.freeload.model.RestEntity;
import ju00.freeload.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface ReivewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findBySvarCd(String svarCd);

    List<ReviewEntity> findByEmail(String email);

    List<ReviewEntity> findAllByEmail(String email);

    List<ReviewEntity> findAll();
}

