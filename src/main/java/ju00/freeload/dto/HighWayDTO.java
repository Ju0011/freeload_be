package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import ju00.freeload.service.ApiRestService;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class HighWayDTO {
    private String routeNm;     //휴게소가 소속된 고속도로 이름
    private String routeCd;     // 고속도로 코드

    public HighWayDTO(ApiRestService.RouteCdProjection projection) {
        this.routeCd = projection.getRouteCd();
        this.routeNm = projection.getRouteNm();
        //this.gudClssCd = projection.getGudClssCd();
    }

    public static RestEntity toEntity(final HighWayDTO dto) {
        return RestEntity.builder()
                .routeNm(dto.getRouteNm())
                .routeCd(dto.getRouteCd())
                .build();
    }
}
