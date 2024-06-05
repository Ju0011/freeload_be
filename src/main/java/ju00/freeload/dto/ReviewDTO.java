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
    private String sliced_rest;   // 휴게소 이름
    private String new_date;        // 리뷰 생성 날짜
    private String content;     // 리뷰 내용
    private Long review_id;


    public ReviewDTO(final ReviewEntity entity) {
        this.email = entity.getEmail();
        this.svarCd = entity.getSvarCd();
        this.sliced_rest = entity.getSliced_rest();
        this.new_date = entity.getNew_date();
        this.content = entity.getContent();
        this.review_id = entity.getReview_id();
    }

    public static ReviewEntity toEntity(final ReviewDTO dto) {
        return ReviewEntity.builder()
                .email(dto.getEmail())
                .svarCd(dto.getSvarCd())
                .sliced_rest(dto.getSliced_rest())
                .new_date(dto.getNew_date())
                .content(dto.getContent())
                .review_id(dto.getReview_id())
                .build();
    }
}
