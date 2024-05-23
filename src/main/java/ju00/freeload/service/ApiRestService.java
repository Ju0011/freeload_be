package ju00.freeload.service;

import ju00.freeload.model.RestEntity;
import ju00.freeload.persistence.RestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class ApiRestService {

    //@Autowired
    private final RestRepository repository;

//   private final ApiRepository repository;

    //    1. 검증(Validations) : 넘어온 엔티티가 유효한지 검사
//    2. save() : 엔티티를 DB에 저장하고 로그를 남김
//    3. findByRouteNmAndGudClssCd() : 저장된 엔티티를 포함하는 새 리스트 리턴

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
    private void validateCd(final Long svarCd) {
        if(svarCd == null) {
            log.warn("svarCd cannot be null.");
            throw new RuntimeException("svarCd cannot be null.");
        }
    }

    //REST 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현 - retrieve 메서드
    public List<RestEntity> retrieve(final String routeNm, final String gudClssCd) {
        return repository.findByRouteNmAndGudClssCd(routeNm, gudClssCd);
    }

    public List<RestEntity> idsearch(final Long svarCd) {
        validateCd(svarCd);
        System.out.println("svarCd : "+svarCd);
        return repository.findBySvarCd(svarCd);
    }

    public interface RouteCdProjection {
        String getRouteCd();
        String getRouteNm();
    }

    // 고속도로 모두 출력
    public List<RouteCdProjection> highSearch() {
        return repository.findDistinctRouteCdAndRouteNm();
    }
}