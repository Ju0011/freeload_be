package ju00.freeload.persistence;

import ju00.freeload.model.RestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository extends JpaRepository<RestEntity, String> {
    List<RestEntity> findByRestId(String RestId);
}

// 스프링 데이터가 JPA 메서드 이름을 파싱해서 select * from todorepository WHERE userId = '{userId}' 쿼리 작성해 실행