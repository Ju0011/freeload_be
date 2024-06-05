package ju00.freeload.controller;

import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.UserDTO;
import ju00.freeload.model.UserEntity;
import ju00.freeload.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class UsersController {

    private final UserService service;

    @PostMapping("/check")
    public ResponseEntity<ResponseDTO<UserDTO>> receiveKakaoUserInfo(@RequestBody UserEntity userInfo) {
        System.out.println("닉네임: " + userInfo.getNickname());
        System.out.println("이메일: " + userInfo.getEmail());
        System.out.println("프로필 이미지: " + userInfo.getProfile_image_url());

        boolean exists = service.checkEmailExists(userInfo.getEmail());
        System.out.println("이메일 존재여부: " + exists);


        if (!exists) {
            ResponseDTO<UserDTO> response = new ResponseDTO<>();
            response.setMessage(true);
            System.out.println("response: " + response);
            return ResponseEntity.ok().body(response);

        } else {
            // (1) 서비스 메서드의 checkFindEmail 메서드를 사용해 테이블을 가져온다
            List<UserEntity> entities = service.checkFindEmail(userInfo.getEmail());

            // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 UserDTO리스트로 변환한다.
            List<UserDTO> dtos = entities.stream().map(UserDTO::new).collect(Collectors.toList());

            // (6) 변환된 UserDTO리스트를 이용해 ResponseDTO를 초기화한다.
            ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(dtos).build();

            System.out.println("response: " + response);
            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok().body(response);
        }


    }

    // 추가정보 입력 저장
    @PostMapping("/join")
    public ResponseEntity<?> retrieveRestTable(@RequestBody UserEntity userInfo) {
        System.out.println("이름: " + userInfo.getName());
        System.out.println("핸드폰: " + userInfo.getPhoneNum());
        System.out.println("출생년도: " + userInfo.getBirthYear());
        System.out.println("성별: " + userInfo.getGender());
        System.out.println("이메일: " + userInfo.getEmail());

        service.saveUser(userInfo);

        return ResponseEntity.ok("추가입력 성공입니다");
    }
}