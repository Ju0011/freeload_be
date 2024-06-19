package ju00.freeload.controller;

import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.UserDTO;
import ju00.freeload.model.UserEntity;
import ju00.freeload.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class UsersController {

    private final UserService service;

    //유저의 상세정보 출력
    @GetMapping("/all")
    public ResponseEntity<?> retrieveAll(@RequestBody UserEntity entity) {

        String email = entity.getEmail();

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<UserEntity> entities = service.findDetailByEmail(email);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO리스트로 변환한다.
        List<UserDTO> dtos = entities.stream().map(UserDTO::new).collect(Collectors.toList());

        // (3) 변환된 ReviewDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(dtos).build();

        // (4) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    // 가입된 유저인지 확인
    @PostMapping("/check")
    public ResponseEntity<ResponseDTO<UserDTO>> receiveKakaoUserInfo(@RequestBody UserEntity userInfo) {
        boolean exists = service.checkEmailExists(userInfo.getEmail());
        System.out.println("이메일 존재여부: " + exists);


        // 신규회원일때
        if (!exists) {
            ResponseDTO<UserDTO> response = new ResponseDTO<>();
            response.setMessage(false);
            System.out.println("response: " + response);
            return ResponseEntity.ok().body(response);

        } else {    //기존유저일때
            // (1) 서비스 메서드의 checkFindEmail 메서드를 사용해 테이블을 가져온다
            Optional<UserEntity> entities = service.checkFindEmail(userInfo.getEmail());

            // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 UserDTO리스트로 변환한다.
            List<UserDTO> dtos = entities.stream().map(UserDTO::new).collect(Collectors.toList());

            // (6) 변환된 UserDTO리스트를 이용해 ResponseDTO를 초기화한다.
            ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(dtos).build();
            response.setMessage(true);
            response.setStatus("이미 가입된 회원입니다.");
            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok().body(response);
        }


    }

    // 추가정보 입력 저장
    @PostMapping("/join")
    public ResponseEntity<?> joinUser(@RequestBody UserEntity userInfo) {
        service.saveUser(userInfo);

        return ResponseEntity.ok("추가입력 성공입니다");
    }

    // 유저 정보 수정
    @PutMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody UserEntity userInfo) {
        try {
            service.updateUser(userInfo);
            return ResponseEntity.ok("수정 성공");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}