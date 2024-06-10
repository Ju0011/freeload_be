package ju00.freeload.controller;

import ju00.freeload.dto.*;
import ju00.freeload.model.WishEntity;
import ju00.freeload.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest")
public class WishController {

    private final WishService service;

    //찜하기 기능 post
    @PostMapping("/{restId}/like")
    public ResponseEntity<?> wishListAdd(@PathVariable("restId") String restId, @RequestBody WishDTO dto) {
        try {
            // (1) ReviewEntity로 변환한다.
            WishEntity entity = WishDTO.toEntity(dto);

            // (2) id를 null로 초기화 한다. 생성 당시에는 id가 없어야 하기 때문
            entity.setWish_id(null);

            // (3) 유저 아이디(이메일), 휴게소 코드 설정
            entity.setEmail(entity.getEmail());
            entity.setSvarCd(restId);

            // (4) 서비스를 이용해 wish 엔티티를 생성한다.
            List<WishEntity> entities = service.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 WishDTO 리스트로 변환한다.
            List<WishDTO> dtos = entities.stream().map(WishDTO::new).collect(Collectors.toList());

            // (6) 변환된 WishDTO리스트를 이용해ResponseDTO를 초기화한다.
            ResponseDTO<WishDTO> response = new ResponseDTO<>();
            response.setMessage(true);
            if(response.isMessage()) {
                response.setStatus("휴게소 즐겨찾기 설정 성공");
            }

            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<WishDTO> response = ResponseDTO.<WishDTO>builder().error(error).build();
            response.setMessage(false);
            return ResponseEntity.badRequest().body(response);
        }
    }
}