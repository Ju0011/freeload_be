package ju00.freeload.service;

import ju00.freeload.model.RestEntity;
import ju00.freeload.persistence.ApiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ApiRestService {

    @Autowired
    private ApiRepository repository;

    //    1. 검증(Validations) : 넘어온 엔티티가 유효한지 검사
//    2. save() : 엔티티를 DB에 저장하고 로그를 남김
//    3. findByuserId() : 저장된 엔티티를 포함하는 새 리스트 리턴


    // Validations 함수
    private void validate(final RestEntity RestEntity) {
        if(RestEntity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(RestEntity.getRestId() == null) {
            log.warn("Unknown RestId.");
            throw new RuntimeException("Unknown user.");
        }
    }

    //REST 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현 - retrieve 메서드
    public List<RestEntity> retrieve(final String userId) {
        return repository.findByUserId(userId);
    }

}