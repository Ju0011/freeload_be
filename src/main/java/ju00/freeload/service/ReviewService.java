package ju00.freeload.service;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import ju00.freeload.persistence.ReivewRepository;
import ju00.freeload.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class ReviewService {
    //@Autowired
    private final ReivewRepository repository;

    public List<ReviewEntity> findReviews(final String svarCd) {
        return repository.findBySvarCd(svarCd);
    }

    public List<ReviewEntity> create(final ReviewEntity entity) {
        // Validations
        validate(entity);

        repository.save(entity);
        log.info("Review_id Entity Id : {} is saved.", entity.getReview_id());
        return repository.findByEmail(entity.getEmail());
    }

    // Validations 함수
    private void validate(final ReviewEntity entity) {
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