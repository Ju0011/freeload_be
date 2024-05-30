package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import ju00.freeload.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class UserDTO {
    private String email;      //
    private String nickname;  // 휴게소 이름
    private String profileImage;   // 주소


    public UserDTO(final UserEntity entity) {
        this.email = entity.getEmail();
        this.nickname = entity.getNickname();
        this.profileImage = entity.getProfile_image_url();
    }

    public static UserEntity toEntity(final UserDTO dto) {
        return UserEntity.builder()
                .email(dto.getEmail())
                .profile_image_url(dto.getProfileImage())
                .nickname(dto.getNickname())
                .build();
    }
}
