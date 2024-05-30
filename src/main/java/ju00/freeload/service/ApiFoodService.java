package ju00.freeload.service;

import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.OilEntity;
import ju00.freeload.model.RestEntity;
import ju00.freeload.persistence.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor    // final 변수들, 필드들을 매개변수로 하는 생성자를 자동으로 생성
@Slf4j
@Service
public class ApiFoodService {

    //@Autowired
    private final FoodRepository repository;

    // 음식 아이디로 찾기
    public List<FoodEntity> findBySeq(final Long seq) {
        return repository.findBySeq(seq);
    }

    // 휴게소 아이디로 찾기
    public List<FoodEntity> findBySvarCd(final Long svarCd) {
        return repository.findBySvarCd(svarCd);
    }
}