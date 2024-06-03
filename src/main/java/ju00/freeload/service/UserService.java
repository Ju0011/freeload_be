package ju00.freeload.service;

import ju00.freeload.model.UserEntity;
import ju00.freeload.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class UserService {

    //@Autowired
    private final UserRepository repository;

    public boolean checkEmailExists(String email) {
        return repository.existsByEmail(email);
    }

    // 유저 정보 저장
    public void saveUser(UserEntity user) {
        repository.save(user);
    }
}