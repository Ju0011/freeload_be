package ju00.freeload.controller;

import ju00.freeload.dto.FoodDTO;
import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.RestDTO;
import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.RestEntity;
import ju00.freeload.service.ApiFoodService;
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
@RequestMapping("rest")
public class ApiFoodController {

//    private ApiRestService service;
    private final ApiFoodService service;

     //Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
    @GetMapping("/food/{routeNm}/{updown}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("routeNm") Long routeNm, @PathVariable("updown") String updown) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<FoodEntity> entities = service.retrieve(routeNm);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
        List<FoodDTO> dtos = entities.stream().map(FoodDTO::new).collect(Collectors.toList());

        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<FoodDTO> response = ResponseDTO.<FoodDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    //Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
//    @GetMapping("/SvarCd/{restId}")
//    public ResponseEntity<?> retrieveRestTable(@PathVariable("restId") Long restId) {
//        System.out.println("restId : " + restId);
//
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
//        return ResponseEntity.ok().body(response);
//    }
}