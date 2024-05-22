package ju00.freeload.controller;
import ju00.freeload.model.RestEntity;
import ju00.freeload.service.ApiRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ju00.freeload.dto.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest")
public class ApiRestController {

//    private ApiRestService service;
    private final ApiRestService service;

     //Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
    @GetMapping("/{routeNm}/{updown}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("routeNm") String routeNm, @PathVariable("updown") String updown) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<RestEntity> entities = service.retrieve(routeNm, updown);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
        List<RestDTO> dtos = entities.stream().map(RestDTO::new).collect(Collectors.toList());

        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<RestDTO> response = ResponseDTO.<RestDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    //Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
    @GetMapping("/SvarCd/{restId}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("restId") Long restId) {
        System.out.println("restId : " + restId);

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<RestEntity> entities = service.idsearch(restId);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
        List<RestDTO> dtos = entities.stream().map(RestDTO::new).collect(Collectors.toList());

        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<RestDTO> response = ResponseDTO.<RestDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);
    }
}