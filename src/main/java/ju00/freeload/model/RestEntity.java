package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "rest")   // 데이터베이스에 REST테이블에 매핑

//@Table(name = "rest",
//        uniqueConstraints = {
//                @UniqueConstraint(
//                        name = "rest_id_unique",
//                        columnNames = {
//                                "rest_server_id",
//                                "rest_server"
//                        }
//                ),
//        }
//)
public class RestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restId;      // 휴게소 아이디
    private String restName;  // 휴게소 이름
    private String restAddr;   // 주소
    private String gudClssCd;   // 상, 하행 구분
    private String routeNm;     //휴게소가 소속된 고속도로 이름

    public RestEntity(Long restId, String restName, String restAddr, String routeNm, String gudClssCd) {
        this.restId = restId;
        this.restName = restName;
        this.restAddr = restAddr;
        this.routeNm = routeNm;
        this.gudClssCd = gudClssCd;
    }
}