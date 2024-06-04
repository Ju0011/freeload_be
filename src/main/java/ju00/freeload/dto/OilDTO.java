package ju00.freeload.dto;

import ju00.freeload.model.OilEntity;
import ju00.freeload.model.RestEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class OilDTO {
    private Long svarCd;      // 휴게소 아이디
    private String serviceAreaName;  // 주유소 이름
    private String svarAddr;   // 주소
    private String gasolinePrice;   // 가솔린 가격
    private String lpgPrice; // lpg 가격
    private String diselPrice; // 디젤 가격
    private String routeNm;     //휴게소가 소속된 고속도로 이름
    private String oilCompany;      // 주유소 회사 이름
    private String telNo;       // 주유소 전화번호
    private String diselAver;
    private String gasolineAver;
    private String lpgAver;
    private String routeCode;

    public OilDTO(final OilEntity entity) {
        this.svarCd = entity.getSvarCd();
        this.serviceAreaName = entity.getServiceAreaName();
        this.svarAddr = entity.getSvarAddr();
        this.gasolinePrice = entity.getGasolinePrice();
        this.lpgPrice = entity.getLpgPrice();
        this.diselPrice = entity.getDiselPrice();
        this.routeCode  = entity.getRouteCode();
        this.routeNm = entity.getRouteNm();
        this.oilCompany = entity.getOilCompany();
        this.telNo = entity.getTelNo();
        this.diselAver = entity.getDiselAver();
        this.gasolineAver = entity.getGasolineAver();
        this.lpgAver = entity.getLpgAver();
    }

    public static OilEntity toEntity(final OilDTO dto) {
        return OilEntity.builder()
                .svarCd(dto.getSvarCd())
                .serviceAreaName(dto.getServiceAreaName())
                .svarAddr(dto.getSvarAddr())
                .gasolinePrice(dto.getGasolinePrice())
                .lpgPrice(dto.getLpgPrice())
                .diselPrice(dto.getDiselPrice())
                .routeCode(dto.getRouteCode())
                .routeNm(dto.getRouteNm())
                .oilCompany(dto.getOilCompany())
                .telNo(dto.getTelNo())
                .diselAver(dto.getDiselAver())
                .gasolineAver(dto.getGasolineAver())
                .lpgAver(dto.getLpgAver())
                .build();
    }
}
