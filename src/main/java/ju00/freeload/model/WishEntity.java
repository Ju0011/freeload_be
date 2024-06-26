package ju00.freeload.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Entity
@Builder
@AllArgsConstructor //this. 대신
@Table(name = "Wishlist")   //
public class WishEntity {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //기본키 자동생성
    private Long wish_id;      // 찜목록 아이디

    @Setter
    @Column(name = "email", nullable = true)
    private String email;  // 유저 이메일
//
//    @Setter
//    @Column(name = "svarCd", nullable = true)
//    private String svarCd;   // 휴게소 코드

//    @ManyToOne //엔티티 사이의 다대일 관계
//    @JoinColumn(name = "email")
//    private UserEntity userEntity;

    @Setter
    @ManyToOne
    @JoinColumn(name = "svarCd")
    private RestEntity restEntity;

    @Override
    public String toString() {
        return "WishEntity{" +
                "wish_id=" + wish_id +
                ", email='" + email + '\'' +
                ", restEntityId='" + (restEntity != null ? restEntity.getSvarCd() : "null") + '\'' +
                '}';
    }

}
