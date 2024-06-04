package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "oil")   // 데이터베이스에 REST테이블에 매핑
public class OilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SvarCd" ,nullable = false, unique = true)
    private Long svarCd;      // 휴게소(주유소) 아이디

    @Setter
    @Column(name = "serviceAreaName", nullable = false)
    private String serviceAreaName;  //  주유소 이름

    @Setter
    @Column(name = "svarAddr")
    private String svarAddr;   // 주소

    @Setter
    @Column(name = "gasolinePrice")
    private String gasolinePrice;   // 가솔린 가격

    @Setter
    @Column(name = "lpgPrice")
    private String lpgPrice;   // lpg 가격

    @Setter
    @Column(name = "diselPrice")
    private String diselPrice;   // 디젤 가격

    @Setter
    @Column(name = "routeCode")
    private String routeCode;     //휴게소가 소속된 고속도로 이름

    @Setter
    @Column(name = "routeName")
    private String routeNm;     //휴게소가 소속된 고속도로 이름

    @Setter
    @Column(name = "oilCompany")    // 주유소 회사이름
    private String oilCompany;

    @Setter
    @Column(name = "telNo")    // 주유소 전화번호
    private String telNo;

    @Setter
    @Column(name = "diselAver")    // 디젤 평균가격
    private String diselAver;

    @Setter
    @Column(name = "gasolineAver")    // 가솔린 평균가격
    private String gasolineAver;

    @Setter
    @Column(name = "lpgAver")    // lpg 평균가격
    private String lpgAver;

}
