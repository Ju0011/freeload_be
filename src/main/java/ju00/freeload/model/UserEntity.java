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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email" , unique = true)
    private String email;      // 유저 이메일

    @Setter
    @Column(name = "nickname", nullable = false)
    private String nickname;  // 유저 닉네임

    @Setter
    @Column(name = "profileImage", nullable = false)
    private String profileImage;  // 유저 프로필 이미지


}
