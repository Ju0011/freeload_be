package ju00.freeload.controller;

import ju00.freeload.dto.FoodDTO;
import ju00.freeload.dto.ResponseDTO;
import ju00.freeload.model.FoodEntity;
import ju00.freeload.service.ApiFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest/food")
public class ApiFoodController {

//    private ApiRestService service;
    private final ApiFoodService service;

    @GetMapping("/{restId}")
    public ResponseEntity<?> getFood(
            @PathVariable("restId") Long restId,
            @RequestParam(value = "sort", required = false) String sort)
            //@RequestParam(value = "cursor", required = false) Integer cursor)
            {

        System.out.println("restId: " + restId);
        System.out.println("sort: " + sort);


        // (1) 서비스 메서드의 findBySeq 사용해 테이블을 가져온다
        List<FoodEntity> entities = service.findBySvarCd(restId);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 FoodDTO리스트로 변환한다.
        List<FoodDTO> dtos = entities.stream().map(FoodDTO::new).collect(Collectors.toList());

        // (3) sort 기능 구현
        if (sort != null) {
            if (sort.equals("RECOMMEND")) {
                // Removing items where recommendyn is 'N'
                dtos.removeIf(food -> "N".equals(food.getRecommendyn()));

            } else if (sort.equals("BEST")) {
                dtos.removeIf(food -> "N".equals(food.getBestfoodyn()));

            } else if (sort.equals("SEASON")) {
                dtos.removeIf(food -> "4".equals(food.getSeasonMenu()));

            } else if (sort.equals("PREMIUM")) {
                dtos.removeIf(food -> "N".equals(food.getPremiumyn()));
            }
        }

//        // (4) 페이지네이션 설정
//        int pageSize = 6;
//        int currentPage = cursor != null ? cursor : 0; // cursor가 null일 경우 0으로 설정
//
//        // 시작 인덱스와 끝 인덱스 계산
//        int fromIndex = currentPage * pageSize;
//        int toIndex = Math.min(fromIndex + pageSize, dtos.size());
//
//        // 만약 시작 인덱스가 리스트의 크기보다 크거나 같다면 빈 리스트 반환
//        if (fromIndex >= dtos.size()) {
//            return ResponseEntity.ok(List.of());
//        }
//
//        // 리스트에서 지정된 범위의 서브리스트를 추출
//        List<FoodDTO> pagedFoodItems = dtos.subList(fromIndex, toIndex);

        // (4) 새 ResponseDTO를 dto 사용해 초기화한다.
        ResponseDTO<FoodDTO> paginatedResponse = ResponseDTO.<FoodDTO>builder().data(dtos).build();

        // (5) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(paginatedResponse);
    }
}