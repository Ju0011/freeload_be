package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "rest")   // 데이터베이스에 REST테이블에 매핑
public class RestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "svarCd" , unique = true)
    private String svarCd;      // 휴게소 아이디

    @Setter
    @Column(name = "svarNm", nullable = false)
    private String restNm;  // 휴게소 이름

    @Setter
    @Column(name = "svarAddr")
    private String restAddr;   // 주소

    @Setter
    @Column(name = "gudClssCd")
    private String gudClssCd;   // 상, 하행 구분

    @Setter
    @Column(name = "routeNm")
    private String routeNm;     //휴게소가 소속된 고속도로 이름

    @Setter
    @Column(name = "routeCd")
    private String routeCd;     //휴게소가 소속된 고속도로 코드

    @Setter
    @Column(name = "hdqrCd")    //본부코드
    private String hdqrCd;

    @Setter
    @Column(name = "rprsTelNo")    //휴게소 전화번호
    private String rprsTelNo;

    @Setter
    @Column(name = "wifi")    //와이파이 유무
    private String wifi;

    @Setter
    @Column(name = "satisfaction")    //만족도
    private String satisfaction;

    @Setter
    @Column(name = "electric_car")    //전기차 충전소 유무
    private String electric_car;

    @Setter
    @Column(name = "nursing_room")    //수유실 유무
    private String nursing_room;

    @Setter
    @Column(name = "pharmacy")    //약국유무
    private String pharmacy;

    @Setter
    @Column(name = "Braile_block")    //점자블록 유무
    private String Braile_block;

    @Setter
    @Column(name = "pet")    //반려동물 시설 유무
    private String pet;

    @Setter
    @Column(name = "latitude")    //위도
    private String latitude;

    @Setter
    @Column(name = "longitude")    //경도
    private String longitude;

    @OneToMany(mappedBy = "restEntity") // rest 엔티티와 Wish 엔티티 사이의 일대다 관계
    private List<WishEntity> wishEntities = new ArrayList<>();

    @Setter
    @Column(name = "isLiked")
    private boolean isLiked;

}
