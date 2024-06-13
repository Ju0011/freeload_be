package ju00.freeload.service;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.RouteEntity;
import ju00.freeload.persistence.ReivewRepository;
import ju00.freeload.persistence.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class RouteService {
    //@Autowired
    private final RouteRepository repository;

    public List<RouteEntity> findRoute(final String email) {
        return repository.findByEmail(email);
    }

    public List<RouteEntity> create(final RouteEntity entity) {
        // Validations
        validate(entity);

        repository.save(entity);
        log.info("Review_id Entity Id : {} is saved.", entity.getRoute_id());
        return repository.findByEmail(entity.getEmail());
    }

    // Validations 함수
    private void validate(final RouteEntity entity) {
        if(entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(entity.getEmail() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

}