package ju00.freeload.dto;

import ju00.freeload.model.ReviewEntity;
import ju00.freeload.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor  // 기본 생성자 자동 추가
@AllArgsConstructor
@Data
public class ReviewDTO {
    private String email;      //유저 이메일
    private String svarCd;  // 휴게소 코드
    private String restNm;   // 휴게소 이름
    private String visitedDate;        // 리뷰 생성 날짜
    private String content;     // 리뷰 내용
    private Long review_id;
    private String storeName;
    private String profile_image;
    private String price;
    private String way;


    public ReviewDTO(final ReviewEntity entity) {
        this.email = entity.getEmail();
        this.svarCd = entity.getSvarCd();
        this.restNm = entity.getRestNm();
        this.visitedDate = entity.getNew_date();
        this.content = entity.getContent();
        this.review_id = entity.getReview_id();
        this.storeName = entity.getStoreName();
        this.profile_image = entity.getProfile_image();
        this.price = entity.getPrice();
        this.way = entity.getWay();
    }

    public static ReviewEntity toEntity(final ReviewDTO dto) {
        return ReviewEntity.builder()
                .email(dto.getEmail())
                .svarCd(dto.getSvarCd())
                .restNm(dto.getRestNm())
                .new_date(dto.getVisitedDate())
                .content(dto.getContent())
                .review_id(dto.getReview_id())
                .storeName(dto.getStoreName())
                .profile_image(dto.getProfile_image())
                .price(dto.getPrice())
                .way(dto.getWay())
                .build();
    }
}
