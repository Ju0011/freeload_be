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
@Table(name = "review")   // 데이터베이스에 REST테이블에 매핑
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //기본키 자동생성
    private Long review_id;      // 리뷰 아이디

    @Setter
    @Column(name = "email", nullable = true)
    private String email;  // 유저 이메일

    @Setter
    @Column(name = "svarCd")
    private String svarCd;   // 휴게소 코드

    @Setter
    @Column(name = "sliced_rest")
    private String sliced_rest;   // 휴게소 이름

    @Setter
    @Column(name = "storeName")
    private String storeName;   // 휴게소 이름

    @Setter
    @Column(name = "visitedDate")
    private String new_date;     // 리뷰 생성 날짜

    @Setter
    @Column(name = "profile_image")
    private String profile_image;     // 유저 프로필 사진

    @Setter
    @Column(name = "content")
    private String content;     // 리뷰 내용

    @Setter
    @Column(name = "price")
    private String price;     // 상품 가격

    @Setter
    @Column(name = "way")
    private String way;     // 인증 방법 (영수증,결제내역)

}
