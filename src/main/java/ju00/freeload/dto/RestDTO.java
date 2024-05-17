//package ju00.freeload.dto;
//
//import ju00.freeload.model.RestEntity;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class RestDTO {
//    private String restId;      // 휴게소 아이디
//    private String restName;  // 휴게소 이름
//    private String restAddr;   // 주소
//    private String gudClssCd;   // 상, 하행 구분
//    private String routeNm;     //휴게소가 소속된 고속도로 이름
//
//    public RestDTO(final RestEntity entity) {
//        this.restId = entity.getRestId();
//        this.restName = entity.getRestName();
//        this.restAddr = entity.getRestAddr();
//        this.routeNm = entity.getRouteNm();
//        this.gudClssCd = entity.getGudClssCd();
//    }
//
//    public static RestEntity toEntity(final RestDTO dto) {
//        return RestEntity.builder()
//                .restId(dto.getRestId())
//                .restName(dto.getRestName())
//                .restAddr(dto.getRestAddr())
//                .routeNm(dto.getRouteNm())
//                .gudClssCd(dto.getGudClssCd())
//                .build();
//    }
//}
