package ju00.freeload.service;
import ju00.freeload.model.WishEntity;
import ju00.freeload.persistence.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class WishService {
    //@Autowired
    private final WishRepository repository;

//    public List<WishEntity> findWish(final WishEntity entity) {
//        return repository.findByUserEntity(entity.getUserEntity());
//    }

//    public List<WishEntity> findWish(final String email) {
//        return repository.findSvarCdByEmail(email);
//    }

    public List<String> findCd(final String email) {
        return repository.findSvarCdByEmail(email);
    }


    public List<WishEntity> create(final WishEntity entity) {
        // Validations
        validate(entity);

        repository.save(entity);
        //return repository.findByUserEntity(entity.getUserEntity());
        return repository.findByEmail(entity.getEmail());
    }

    // Validations 함수
    private void validate(final WishEntity entity) {
        if(entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        //if(entity.getUserEntity() == null) {
        if(entity.getEmail() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

}