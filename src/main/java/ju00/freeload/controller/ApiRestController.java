package ju00.freeload.controller;
import ju00.freeload.service.ApiRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class ApiRestController {

    private ApiRestService service;

    // Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
//    @GetMapping("/{restNm}/{updown}")
//    public ResponseEntity<?> retrieveRestTable(@PathVariable String restNm, @PathVariable String updown) {
//        int gudClssCd


//        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
//        List<RestEntity> entities = service.retrieve(restNm);
//
//        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
//        List<RestDTO> dtos = entities.stream().map(RestDTO::new).collect(Collectors.toList());
//
//        // (6) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
//        ResponseDTO<RestDTO> response = ResponseDTO.<RestDTO>builder().data(dtos).build();
//
//        // (7) ResponseDTO를 리턴한다.
//        return ResponseEntity.ok().body(response);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{restNm}/{PPP}")
    public List<Map<String, Object>> getRouteNmByRestNm(@PathVariable String restNm, @PathVariable String up) {
        String sql = "SELECT * FROM rest WHERE restNm = ? AND gudClssCd = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, restNm, up);
        return result;
    }

    @GetMapping("/{restNm}/{up}")
    public String testAPIController(@PathVariable String restNm, @PathVariable String up) {
        return "{\"message\": {restNm}, {up}";
    }
}