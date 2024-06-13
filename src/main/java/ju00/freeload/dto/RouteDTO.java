package ju00.freeload.dto;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.RouteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class RouteDTO {
    private Long route_id;
    private String email;      //유저 이메일
    private String startAddr;
    private String startLatLng;
    private String endAddr;
    private String endLatLng;


    public RouteDTO(final RouteEntity entity) {
        this.email = entity.getEmail();
        this.startAddr = entity.getStartAddr();
        this.startLatLng = entity.getStartLatLng();
        this.endAddr = entity.getEndAddr();
        this.endLatLng = entity.getEndLatLng();
        this.route_id = entity.getRoute_id();
    }

    public static RouteEntity toEntity(final RouteDTO dto) {
        return RouteEntity.builder()
                .email(dto.getEmail())
                .startAddr(dto.getStartAddr())
                .startLatLng(dto.getStartLatLng())
                .endAddr(dto.getEndAddr())
                .endLatLng(dto.getEndLatLng())
                .build();
    }
}
