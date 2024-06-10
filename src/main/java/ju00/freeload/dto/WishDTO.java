package ju00.freeload.dto;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.WishEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class WishDTO {
    private String email;      //유저 이메일
    private String svarCd;  // 휴게소 코드
    private Long wish_id;


    public WishDTO(final WishEntity entity) {
        this.email = entity.getEmail();
        this.svarCd = entity.getSvarCd();
        this.wish_id = entity.getWish_id();

    }

    public static WishEntity toEntity(final WishDTO dto) {
        return WishEntity.builder()
                .email(dto.getEmail())
                .svarCd(dto.getSvarCd())
                .wish_id(dto.getWish_id())
                .build();
    }
}
