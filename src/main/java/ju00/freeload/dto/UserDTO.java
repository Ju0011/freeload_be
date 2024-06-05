package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import ju00.freeload.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class UserDTO {
    private String email;      //유저 이메일
    private String nickname;  // 유저 닉네임(삭제예정)
    private String profileImage;   // 유저 프사
    private String phoneNum;        // 유저 핸드폰 번호


    public UserDTO(final UserEntity entity) {
        this.email = entity.getEmail();
        this.nickname = entity.getNickname();
        this.profileImage = entity.getProfile_image_url();
        this.phoneNum = entity.getPhoneNum();
    }

    public static UserEntity toEntity(final UserDTO dto) {
        return UserEntity.builder()
                .email(dto.getEmail())
                .profile_image_url(dto.getProfileImage())
                .nickname(dto.getNickname())
                .phoneNum(dto.getPhoneNum())
                .build();
    }
}
