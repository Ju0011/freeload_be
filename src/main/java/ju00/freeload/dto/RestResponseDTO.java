package ju00.freeload.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestResponseDTO<T> {
    private String error;
    private List<T> data;
    private boolean message;
}
