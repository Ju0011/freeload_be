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

//    private ApiRestService service;
    private final UserService service;

    @PostMapping("/check")
    public ResponseEntity<String> receiveKakaoUserInfo(@RequestBody UserEntity userInfo) {
        System.out.println("닉네임: " + userInfo.getNickname());
        System.out.println("이메일: " + userInfo.getEmail());
        System.out.println("프로필 이미지: " + userInfo.getProfileImage());

        boolean exists = service.checkEmailExists(userInfo.getEmail());
        System.out.println("이메일 존재여부: " + exists);
        //return ResponseEntity.ok(exists);

        if (!exists) {
            service.saveUser(userInfo);
        }

        return ResponseEntity.ok("이미 가입된 회원입니다.");
    }

    // 추가정보 입력 저장
    @PostMapping("/join")
    public ResponseEntity<?> retrieveRestTable(@RequestBody UserEntity userInfo) {
        System.out.println("이름: " + userInfo.getUsername());
        System.out.println("핸드폰: " + userInfo.getPhoneNum());
        System.out.println("출생년도: " + userInfo.getBirthYear());
        System.out.println("성별: " + userInfo.getGender());

        service.saveUser(userInfo);

//        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
//        List<RestEntity> entities = service.idsearch(restId);
//
//        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
//        List<RestDTO> dtos = entities.stream().map(RestDTO::new).collect(Collectors.toList());
//
//        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
//        ResponseDTO<RestDTO> response = ResponseDTO.<RestDTO>builder().data(dtos).build();
//
//        // (7) ResponseDTO를 리턴한다.
        //return ResponseEntity.ok().body(response);
        return ResponseEntity.ok("추가입력 성공입니다");
    }
}