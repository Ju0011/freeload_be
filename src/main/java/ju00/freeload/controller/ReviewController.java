package ju00.freeload.controller;

import ju00.freeload.dto.*;
import ju00.freeload.model.ReviewEntity;
import ju00.freeload.persistence.RestRepository;
import ju00.freeload.service.ImageUploadService;
import ju00.freeload.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("review")
public class ReviewController {

    private final ReviewService service;
    private final RestRepository restRepository;

    @Autowired
    private ImageUploadService imageUploadService;

    //review 테이블 - 한 유저의 모든 리뷰 출력
    @GetMapping("/all")
    public ResponseEntity<?> retrieveAll(@RequestBody ReviewEntity entity) {

        String email = entity.getEmail();

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<ReviewEntity> entities = service.findAllReviewsByEmail(email);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO리스트로 변환한다.
        List<ReviewDTO> dtos = entities.stream().map(ReviewDTO::new).collect(Collectors.toList());

        // (3) 변환된 ReviewDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<ReviewDTO> response = ResponseDTO.<ReviewDTO>builder().data(dtos).build();

        // (4) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

     //review 테이블 출력
    @GetMapping("/{svarCd}")
    public ResponseEntity<?> retrieveRestTable(@PathVariable("svarCd") String svarCd) {

        // (1) 서비스 메서드의 retrieve메서드를 사용해 테이블을 가져온다
        List<ReviewEntity> entities = service.findReviews(svarCd);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO리스트로 변환한다.
        List<ReviewDTO> dtos = entities.stream().map(ReviewDTO::new).collect(Collectors.toList());

        // (3) 변환된 ReviewDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<ReviewDTO> response = ResponseDTO.<ReviewDTO>builder().data(dtos).build();

        // (4) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(response);

    }

    //review 테이블에 삽입하는 기능
    @PostMapping
    public ResponseEntity<?> createReview(@RequestPart(value = "dto") ReviewDTO dto, @RequestPart(value = "file") MultipartFile file) {
        try {

            // 이미지 업로드
            String imageUrl = imageUploadService.uploadImage(file);


            // (1) ReviewEntity로 변환한다.
            ReviewEntity entity = ReviewDTO.toEntity(dto);

            // 테이블에 restNm 저장하기 위해 rest 테이블 조회
            String svarCd = entity.getSvarCd();
            String restNm = restRepository.findRestNmBySvarCd(svarCd);
            entity.setRestNm(restNm);


            // (2) id를 null로 초기화 한다. 생성 당시에는 id가 없어야 하기 때문
            entity.setReview_id(null);

            // 파일 경로를 엔티티에 설정
            entity.setFilePath(imageUrl);

            // (3) 서비스를 이용해 Review 엔티티를 생성한다.
            List<ReviewEntity> entities = service.create(entity);


            // (3) 자바 스트림을 이용해 리턴된 엔티티 리스트를 ReviewDTO 리스트로 변환한다.
            List<ReviewDTO> dtos = entities.stream().map(ReviewDTO::new).collect(Collectors.toList());

            //true, false 만 출력
            ResponseDTO<ReviewDTO> response = new ResponseDTO<>();
            response.setMessage(true);

            // (4) ResponseDTO를 리턴한다.
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            // (5) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<ReviewDTO> response = ResponseDTO.<ReviewDTO>builder().error(error).build();
            response.setMessage(false);
            return ResponseEntity.badRequest().body(response);
        }
    }

}