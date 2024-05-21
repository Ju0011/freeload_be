package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity(name = "rest")
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "rest")   // 데이터베이스에 REST테이블에 매핑
public class RestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // 행 17개
    @Column(name = "SvarCd" ,nullable = false, unique = true)
    private Long svarCd;      // 휴게소 아이디

    @Setter
    @Column(name = "restNm", nullable = false)
    private String restNm;  // 휴게소 이름

    @Setter
    @Column(name = "restAddr")
    private String restAddr;   // 주소

    @Setter
    @Column(name = "gudClssCd")
    private String gudClssCd;   // 상, 하행 구분

    @Setter
    @Column(name = "routeNm")
    private String routeNm;     //휴게소가 소속된 고속도로 이름

//    private String rprsTelNo;
//    private String svarCd;
//    private String sliced_rest;
//    private String wifi;
//    private String satisfation;
//    private String electric_car;
//    private String nursing_room;
//    private String pharmacy;
//    private String Braile_block;
//    private String pet;
//    private String latitude;
//    private String longitude;


//    public RestEntity(Long svarCd, String restNm, String restAddr, String routeNm, String gudClssCd) {
//        this.svarCd = svarCd;
//        this.restNm = restNm;
//        this.restAddr = restAddr;
//        this.routeNm = routeNm;
//        this.gudClssCd = gudClssCd;
//    }
}