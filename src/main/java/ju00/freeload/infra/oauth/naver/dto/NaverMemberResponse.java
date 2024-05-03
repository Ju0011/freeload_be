package ju00.freeload.infra.oauth.naver.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ju00.freeload.domain.OauthId;
import ju00.freeload.domain.OauthMember;

import java.time.LocalDateTime;

import static ju00.freeload.domain.OauthServerType.KAKAO;
import static ju00.freeload.domain.OauthServerType.NAVER;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverMemberResponse(
        String resultcode,
        String message,
        Response response
) {

    public OauthMember toDomain() {
        return OauthMember.builder()
                .oauthId(new OauthId(String.valueOf(response.id), NAVER))
                .nickname(response.nickname)
                .profileImageUrl(response.profileImage)
                .build();
    }

    @JsonNaming(value = SnakeCaseStrategy.class)
    public record Response(
            String id,
            String nickname,
            String name,
            String email,
            String gender,
            String age,
            String birthday,
            String profileImage,
            String birthyear,
            String mobile
    ) {
    }
}