package ju00.freeload.persistence;

import ju00.freeload.model.RestEntity;
import ju00.freeload.service.ApiRestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//JpaRepository<Entity클래스, pk타입>
@Repository
public interface RestRepository extends JpaRepository<RestEntity, Long> {
    List<RestEntity> findByRouteNmAndGudClssCd(String routeNm, String gudClssCd);
    //@Query("SELECT * FROM rest WHERE routeNm = routeNm AND gudClssCd = gudClssCd")

    List<RestEntity> findBySvarCd(String svarCd);

    @Query(value = "SELECT DISTINCT routeCd, routeNm FROM rest", nativeQuery = true)
    List<ApiRestService.RouteCdProjection> findDistinctRouteCdAndRouteNm();


    @Query("SELECT r FROM RestEntity r WHERE r.svarCd IN :svarCds")
    List<RestEntity> findBySvarCd(@Param("svarCds") List<String> svarCds);

    @Query("SELECT r.restNm FROM RestEntity r WHERE r.svarCd = :svarCd")
    String findRestNmBySvarCd(String svarCd);

    @Query("SELECT l FROM RestEntity l WHERE l.latitude IS NOT NULL AND l.longitude IS NOT NULL")
    List<RestEntity> findAllWithLatitudeAndLongitude();
}