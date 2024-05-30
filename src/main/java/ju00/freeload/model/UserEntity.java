package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "user")   // 데이터베이스에 REST테이블에 매핑
public class UserEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;      // 유저 이메일

    @Setter
    @Column(name = "nickname")
    private String nickname;  // 유저 닉네임

    @Setter
    @Column(name = "profile_image")
    private String profile_image_url;  // 유저 프로필 이미지


    @Setter
    @Column(name = "username")
    private String username;  // 유저 이름

    @Setter
    @Column(name = "birthYear")
    private Integer birthYear;  // 유저 연생


    @Setter
    @Column(name = "phoneNum")
    private String phoneNum;  // 유저 핸드폰 번호

    @Setter
    @Column(name = "gender")
    private String gender;  // 유저 성별


}
