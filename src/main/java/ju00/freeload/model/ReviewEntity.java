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
    @GeneratedValue(generator = "system-uuid")  // 아이디 자동생성
    @GenericGenerator(name = "review_id", strategy = "uuid")
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
    @Column(name = "new_date")
    private String new_date;     // 리뷰 생성 날짜

    @Setter
    @Column(name = "profile_image")
    private String profile_image;     // 유저 프로필 사진

    @Setter
    @Column(name = "content")
    private String content;     // 리뷰 내용

}
