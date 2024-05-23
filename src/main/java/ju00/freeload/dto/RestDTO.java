package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class RestDTO {
    private Long restId;      // 휴게소 아이디
    private String restName;  // 휴게소 이름
    private String restAddr;   // 주소
    private String gudClssCd;   // 상, 하행 구분
    private String routeNm;     //휴게소가 소속된 고속도로 이름
    private String hdqrCd;      //본부코드
    private String routeCd;     // 고속도로 코드

    public RestDTO(final RestEntity entity) {
        this.restId = entity.getSvarCd();
        this.restName = entity.getRestNm();
        this.restAddr = entity.getRestAddr();
        this.routeNm = entity.getRouteNm();
        this.gudClssCd = entity.getGudClssCd();
        this.hdqrCd = entity.getHdqrCd();
        this.routeCd = entity.getRouteCd();
    }

    public static RestEntity toEntity(final RestDTO dto) {
        return RestEntity.builder()
                .svarCd(dto.getRestId())
                .restNm(dto.getRestName())
                .restAddr(dto.getRestAddr())
                .routeNm(dto.getRouteNm())
                .gudClssCd(dto.getGudClssCd())
                .hdqrCd(dto.getHdqrCd())
                .routeCd(dto.getRouteCd())
                .build();
    }
}
