package ju00.freeload.persistence;

import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.OilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    List<FoodEntity> findBySeq(Long seq);
    //@Query("SELECT * FROM rest WHERE routeNm = routeNm AND gudClssCd = gudClssCd")
}

// 스프링 데이터가 JPA 메서드 이름을 파싱해서
// select * from rest WHERE routeNm = '{routeNm}' and  gudClssCd = {'gudClssCd'} 쿼리 작성해 실행