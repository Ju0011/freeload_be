package ju00.freeload.controller;

import ju00.freeload.dto.OilDTO;
import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.RestDTO;
import ju00.freeload.model.OilEntity;
import ju00.freeload.service.ApiOilService;
import ju00.freeload.service.ApiRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("oil")
public class ApiOilController {

    private final ApiOilService service;

     //Oil 휴게소 내의 주유소 출력 (상세내역) - 단일검색
    @GetMapping("/detail/{svarCd}/{updown}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("svarCd") Long svarCd, @PathVariable("updown") String updown) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<OilEntity> entities = service.retrieve(svarCd);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 OilDTO 리스트로 변환한다.
        List<OilDTO> dtos = entities.stream().map(OilDTO::new).collect(Collectors.toList());

        // (6) 변환된 OilDTO 리스트를 이용해 ResponseDTO를 초기화한다.
        ResponseDTO<OilDTO> response = ResponseDTO.<OilDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    //Oil - 고속도로 내의 주유소 리스트 출력
    @GetMapping("/{RouteCd}/{updown}")
    public ResponseEntity<?> oilInHighWay(@PathVariable("RouteCd") String RouteCd, @PathVariable("updown") String updown) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<OilEntity> entities = service.oilInHighWay(RouteCd);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
        List<OilDTO> dtos = entities.stream().map(OilDTO::new).collect(Collectors.toList());

        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<OilDTO> response = ResponseDTO.<OilDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);
    }
}