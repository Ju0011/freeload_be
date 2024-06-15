package ju00.freeload.controller;

import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.ReviewDTO;
import ju00.freeload.dto.RouteDTO;
import ju00.freeload.model.RouteEntity;
import ju00.freeload.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("route")
public class RouteController {

    private final RouteService service;

     //review 테이블 출력
    @GetMapping("/like")
    public ResponseEntity<?> retrieveRestTable(@RequestBody RouteDTO dto) {
        // (1) RouteEntity로 변환
        RouteEntity entity = RouteDTO.toEntity(dto);

        //email 추출
        String email = entity.getEmail();

        // (2) 서비스 메서드의 find 메서드를 사용해 테이블을 가져온다
        List<RouteEntity> entities = service.findRoute(email);

        // (3) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO리스트로 변환한다.
        List<RouteDTO> dtos = entities.stream().map(RouteDTO::new).collect(Collectors.toList());

        // (4) 변환된 RouteDTO리스트를 이용해 ResponseDTO를 초기화한다.
        ResponseDTO<RouteDTO> response = ResponseDTO.<RouteDTO>builder().data(dtos).build();

        // (5) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    //review 테이블에 삽입하는 기능 - post
    @PostMapping("/like")
    public ResponseEntity<?> createRoute(@RequestBody RouteDTO dto) {
        try {

            // (1) RouteEntity로 변환한다.
            RouteEntity entity = RouteDTO.toEntity(dto);

            // (2) id를 null로 초기화 한다. 생성 당시에는 id가 없어야 하기 때문
            entity.setRoute_id(null);

            // (3) 유저 아이디(이메일) 설정
            //entity.setEmail(entity);

            // (4) 서비스를 이용해 Route 엔티티를 생성한다.
            List<RouteEntity> entities = service.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO 리스트로 변환한다.
            List<RouteDTO> dtos = entities.stream().map(RouteDTO::new).collect(Collectors.toList());

            // (6) 변환된 ReviewDTO리스트를 이용해ResponseDTO를 초기화한다.
            //true, false 만 출력
            ResponseDTO<ReviewDTO> response = new ResponseDTO<>();
            response.setMessage(true);
            response.setStatus("경로 즐겨찾기 등록 성공!");

            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<RouteDTO> response = ResponseDTO.<RouteDTO>builder().error(error).build();
            response.setMessage(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

}