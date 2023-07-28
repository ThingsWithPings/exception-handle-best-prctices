package thins.with.pings.exceptionhandle.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String status;
    private String message;
    private Object data;
}
