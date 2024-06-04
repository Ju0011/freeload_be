package ju00.freeload.persistence;

import ju00.freeload.model.OilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface OilRepository extends JpaRepository<OilEntity, Long> {
    List<OilEntity> findBySvarCd(Long svarCd);
    //@Query("SELECT * FROM oil WHERE svarCd = svarCd)

    List<OilEntity> findByRouteCode(String RouteCd);
}