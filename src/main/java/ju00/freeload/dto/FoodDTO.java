package ju00.freeload.dto;

import ju00.freeload.model.FoodEntity;
import ju00.freeload.model.OilEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class FoodDTO {
    //13개
    private Long seq;      // 음식 아이디
    private Long svarCd;  // 휴게소 코드
    private String stdRestNm;   // 휴게소 이름
    private String svarAddr;   // 휴게소 주소
    private String bestfoodyn; // 베스트 메뉴
    private Integer foodCost; // 음식가격
    private String foodNm;     // 음식이름
    private String lsttmAltrDttm;      // 수정 날짜
    private String premiumyn;       // 프리미엄 메뉴
    private String recommendyn;     // 추천메뉴
    private String routeCd;         // 고속도고 코드
    private String routeNm;         // 고속도로 이름
    private String seasonMenu;      // 시즌메뉴

    public FoodDTO(final FoodEntity entity) {
        this.svarCd = entity.getSvarCd();
        this.foodNm = entity.getFoodNm();
        this.lsttmAltrDttm = entity.getLsttmAltrDttm();
        this.premiumyn = entity.getPremiumyn();
        this.recommendyn = entity.getRecommendyn();
        this.routeCd = entity.getRouteCd();
        this.routeNm = entity.getRouteNm();
        this.seasonMenu = entity.getSeasonMenu();
        this.svarAddr = entity.getSvarAddr();
        this.foodCost = entity.getFoodCost();
        this.seq = entity.getSeq();
        this.stdRestNm = entity.getStdRestNm();
        this.bestfoodyn = entity.getBestfoodyn();
    }

    public static FoodEntity toEntity(final FoodDTO dto) {
        return FoodEntity.builder()
                .svarCd(dto.getSvarCd())
                .foodNm(dto.getFoodNm())
                .foodCost(dto.getFoodCost())
                .lsttmAltrDttm(dto.getLsttmAltrDttm())
                .premiumyn(dto.getPremiumyn())
                .recommendyn(dto.getRecommendyn())
                .routeCd(dto.getRouteCd())
                .routeNm(dto.getRouteNm())
                .seasonMenu(dto.getSeasonMenu())
                .svarAddr(dto.getSvarAddr())
                .seq(dto.getSeq())
                .stdRestNm(dto.getStdRestNm())
                .bestfoodyn(dto.getBestfoodyn())
                .build();
    }
}
