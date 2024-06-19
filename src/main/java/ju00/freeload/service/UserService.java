package ju00.freeload.service;

import ju00.freeload.model.OilEntity;
import ju00.freeload.model.RestEntity;
import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import ju00.freeload.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class UserService {

    //@Autowired
    private final UserRepository repository;

    public boolean checkEmailExists(String email) {
        return repository.existsByEmail(email);
    }

    public Optional<UserEntity> checkFindEmail(final String email) {
        return repository.findByEmail(email);
    }

    // 유저 정보 저장
    public void saveUser(UserEntity user) {
        repository.save(user);
    }

    public List<UserEntity> findDetailByEmail(final String email) {
        return repository.findAllByEmail(email);
    }

    //유저 업데이트
    public UserEntity updateUser(UserEntity updatedUser) {
        Optional<UserEntity> originUser = repository.findByEmail(updatedUser.getEmail());
        if (originUser.isPresent()) {
            UserEntity editedUser = originUser.get();
            editedUser.setEmail(updatedUser.getEmail());
            editedUser.setName(updatedUser.getName());
            editedUser.setProfile_image_url(updatedUser.getProfile_image_url());
            editedUser.setBirthYear(updatedUser.getBirthYear());
            editedUser.setGender(updatedUser.getGender());
            editedUser.setSave(updatedUser.getSave());
            editedUser.setPhoneNum(updatedUser.getPhoneNum());

            return repository.save(editedUser);
        } else {
            throw new RuntimeException("User not found with email " + updatedUser.getEmail());
        }
    }
}