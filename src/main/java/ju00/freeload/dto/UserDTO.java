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
    private String username;  // 유저 이름
    private String profileImage;   // 유저 프사
    private String phoneNum;        // 유저 핸드폰 번호
    private Integer birthYear;
    private String gender;


    public UserDTO(final UserEntity entity) {
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.profileImage = entity.getProfile_image_url();
        this.phoneNum = entity.getPhoneNum();
        this.birthYear = entity.getBirthYear();
        this.gender = entity.getGender();
    }

    public static UserEntity toEntity(final UserDTO dto) {
        return UserEntity.builder()
                .email(dto.getEmail())
                .profile_image_url(dto.getProfileImage())
                .nickname(dto.getUsername())
                .phoneNum(dto.getPhoneNum())
                .birthYear(dto.getBirthYear())
                .gender(dto.getGender())
                .build();
    }
}
