package ju00.freeload.dto;

import ju00.freeload.model.RestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class RestDTO {
    private String restId;      // 휴게소 아이디
    private String restName;  // 휴게소 이름
    private String restAddr;   // 주소
    private String gudClssCd;   // 상, 하행 구분
    private String routeNm;     //휴게소가 소속된 고속도로 이름
    private String hdqrCd;      //본부코드
    private String routeCd;     // 고속도로 코드
    private String rprsTelNo;
    private String wifi;
    private String satisfaction;
    private String electric_car;
    private String nursing_room;
    private String pharmacy;
    private String Braile_block;
    private String pet;
    private String latitude;
    private String longitude;
    private Boolean isLiked;


    public RestDTO(final RestEntity entity) {
        this.restId = entity.getSvarCd();
        this.restName = entity.getRestNm();
        this.restAddr = entity.getRestAddr();
        this.routeNm = entity.getRouteNm();
        this.gudClssCd = entity.getGudClssCd();
        this.hdqrCd = entity.getHdqrCd();
        this.routeCd = entity.getRouteCd();
        this.rprsTelNo = entity.getRprsTelNo();
        this.wifi = entity.getWifi();
        this.satisfaction = entity.getSatisfaction();
        this.electric_car = entity.getElectric_car();
        this.nursing_room = entity.getNursing_room();
        this.pharmacy = entity.getPharmacy();
        this.Braile_block = entity.getBraile_block();
        this.pet = entity.getPet();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.isLiked = entity.isLiked();
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
                .rprsTelNo(dto.getRprsTelNo())
                .wifi(dto.getWifi())
                .satisfaction(dto.getSatisfaction())
                .electric_car(dto.getElectric_car())
                .nursing_room(dto.getNursing_room())
                .pharmacy(dto.getPharmacy())
                .Braile_block(dto.getBraile_block())
                .pet(dto.getPet())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }
}
