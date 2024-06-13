package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "route")   // 데이터베이스에 route 테이블에 매핑
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //기본키 자동생성
    private Long route_id;      // 루트 아이디

    @Setter
    @Column(name = "email", nullable = true)
    private String email;  // 유저 이메일

    @Setter
    @Column(name = "startAddr")
    private String startAddr;   // 시작 주소(한글)

    @Setter
    @Column(name = "startLatLng")
    private String startLatLng;   // 시작 위도적도

    @Setter
    @Column(name = "endAddr")
    private String endAddr;   // 종착지

    @Setter
    @Column(name = "endLatLng")
    private String endLatLng;     // 종착지 위도 적도

}
