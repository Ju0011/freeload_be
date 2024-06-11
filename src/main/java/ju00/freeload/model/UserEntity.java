package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Data
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "user")   // 데이터베이스에 user 테이블에 매핑
public class UserEntity {

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
    private String name;  // 유저 이름

    @Setter
    @Column(name = "birthYear")
    private Integer birthYear;  // 유저 출생년도

    @Setter
    @Column(name = "phoneNum")
    private String phoneNum;  // 유저 핸드폰 번호

    @Setter
    @Column(name = "gender")
    private String gender;  // 유저 성별

    @Setter
    @Column(name = "save")
    private String save;  // 유저가 저장한 휴게소(찜하기)

//    @OneToMany(mappedBy = "userEntity") //User 엔티티와 Wish 엔티티 사이의 일대다 관계
//    private List<WishEntity> wishEntities = new ArrayList<>();
}
