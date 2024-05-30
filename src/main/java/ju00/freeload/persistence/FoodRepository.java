package ju00.freeload.persistence;

import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.OilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, String> {

    List<FoodEntity> findBySvarCd(Long svarCd);

    List<FoodEntity> findBySeq(Long seq);
    //@Query("SELECT * FROM rest WHERE routeNm = routeNm AND gudClssCd = gudClssCd")
}
