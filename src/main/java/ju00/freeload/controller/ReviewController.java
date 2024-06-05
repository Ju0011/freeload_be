package ju00.freeload.controller;

import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.dto.RestDTO;
import ju00.freeload.dto.ReviewDTO;
import ju00.freeload.model.RestEntity;
import ju00.freeload.model.ReviewEntity;
import ju00.freeload.persistence.ReivewRepository;
import ju00.freeload.service.ApiRestService;
import ju00.freeload.service.ReviewService;
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
@RequestMapping("review")
public class ReviewController {
    private final ReviewService service;

     //Rest 테이블을 검색하는 리포지터리, 서비스, 컨트롤러 구현
    @GetMapping("/{svarCd}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("svarCd") String svarCd) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<ReviewEntity> entities = service.findReviews(svarCd);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 RestDTO리스트로 변환한다.
        List<ReviewDTO> dtos = entities.stream().map(ReviewDTO::new).collect(Collectors.toList());

        // (6) 변환된 RestDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<ReviewDTO> response = ResponseDTO.<ReviewDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }
}