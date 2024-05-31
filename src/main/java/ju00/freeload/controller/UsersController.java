package ju00.freeload.controller;

import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.RestDTO;
import ju00.freeload.model.RestEntity;
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
    public ResponseEntity<String> receiveKakaoUserInfo(@RequestBody UserEntity userInfo) {
        System.out.println("닉네임: " + userInfo.getNickname());
        System.out.println("이메일: " + userInfo.getEmail());
        System.out.println("프로필 이미지: " + userInfo.getProfile_image_url());

        boolean exists = service.checkEmailExists(userInfo.getEmail());
        System.out.println("이메일 존재여부: " + exists);

        if (!exists) {
            //service.saveUser(userInfo);
            return ResponseEntity.ok("새로운 회원이 등록되었습니다.");
        }

        return ResponseEntity.ok("이미 가입된 회원입니다.");
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