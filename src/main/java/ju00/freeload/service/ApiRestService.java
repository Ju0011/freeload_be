package ju00.freeload.service;

import ju00.freeload.model.RestEntity;
import ju00.freeload.persistence.RestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class ApiRestService {

    //@Autowired
    private final RestRepository repository;

    // Validations 함수
    private void validateEntity(final RestEntity RestEntity) {
        if(RestEntity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(RestEntity.getSvarCd() == null) {
            log.warn("Unknown RestId.");
            throw new RuntimeException("Unknown user.");
        }
    }

    // Validations 함수
    private void validateCd(final String svarCd) {
        if(svarCd == null) {
            log.warn("svarCd cannot be null.");
            throw new RuntimeException("svarCd cannot be null.");
        }
    }

    //push를 위한 위,경도가 있는 휴게소만 출력
    public List<RestEntity> retrieveAll() {
        return repository.findAllWithLatitudeAndLongitude();
    }

    public List<RestEntity> retrieve(final String routeNm, final String updown) {
        return repository.findByRouteNmAndGudClssCd(routeNm, updown);
    }

    // 단일검색 메소드
    public List<RestEntity> idsearch(final String svarCd) {
        validateCd(svarCd);
        System.out.println("svarCd : "+svarCd);
        return repository.findBySvarCd(svarCd);
    }



    // 고속도로 모두 출력
    public interface RouteCdProjection {
        String getRouteCd();
        String getRouteNm();
    }

    // 고속도로 모두 출력
    public List<RouteCdProjection> highSearch() {
        return repository.findDistinctRouteCdAndRouteNm();
    }


    // 찜리스트에 들어있는 휴게소들 출력
    public List<RestEntity> getRestsBySvarCds(List<String> svarCds) {
        return repository.findBySvarCd(svarCds);
    }

    // isLiked
    public List<RestEntity> getRestEntitiesWithLikeStatus(List<String> svarCds, List<RestEntity> entities) {
        Set<String> svarCdSet = Set.copyOf(svarCds);

        for (RestEntity entity : entities) {
            for (String svarCd : svarCdSet) {
                if(entity.getSvarCd().equals(svarCd)) {
                    entity.setLiked(true);
                }
            }
        }
        return entities;
    }
}