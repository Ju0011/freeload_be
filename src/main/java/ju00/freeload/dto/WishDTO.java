package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import ju00.freeload.model.WishEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class WishDTO {
    private String email;      //유저 이메일
//    private String svarCd;  // 휴게소 코드
    private Long wish_id;

    private UserEntity userEntity;      //유저 이메일 받아올 엔티티
    private RestEntity restEntity;  // 휴게소 코드


    public WishDTO(final WishEntity entity) {
        //this.userEntity = entity.getUserEntity();
        this.restEntity = entity.getRestEntity();
        this.wish_id = entity.getWish_id();

        this.email = entity.getEmail();
    }

    public static WishEntity toEntity(final WishDTO dto) {
        return WishEntity.builder()
                //.userEntity(dto.getUserEntity())
                .restEntity(dto.getRestEntity())
                .wish_id(dto.getWish_id())

                .email(dto.getEmail())
                .build();
    }
}
