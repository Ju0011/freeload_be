package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "food")   // 데이터베이스에 food 테이블에 매핑
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")    // 음식 시퀀스 (id)
    private Long seq;

    @Column(name = "SvarCd" ,nullable = false, unique = true)
    private Long svarCd;      // 휴게소 아이디

    @Column(name = "stdRestNm" ,nullable = false, unique = true)
    private String stdRestNm;    //휴게소 이름

    @Setter
    @Column(name = "svarAddr")
    private String svarAddr;  //  주소

    @Setter
    @Column(name = "bestfoodyn", nullable = false)
    private String bestfoodyn;   // 베스트 메뉴 y/n

    @Setter
    @Column(name = "foodCost")
    private Integer foodCost;   // 음식 가격

    @Setter
    @Column(name = "foodNm")
    private String foodNm;   // 음식 이름

    @Setter
    @Column(name = "lsttmAltrDttm")
    private String lsttmAltrDttm;   // 수정 날짜

    @Setter
    @Column(name = "premiumyn")
    private String premiumyn;     // 프리미엄 메뉴

    @Setter
    @Column(name = "recommendyn")    // 추천메뉴
    private String recommendyn;

    @Setter
    @Column(name = "routeCd")    // 고속도로 코드
    private String routeCd;

    @Setter
    @Column(name = "routeNm")    // 고속도로 코드
    private String routeNm;

    @Setter
    @Column(name = "seasonMenu")    // 고속도로 코드
    private String seasonMenu;

}
