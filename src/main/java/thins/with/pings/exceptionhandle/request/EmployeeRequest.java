package thins.with.pings.exceptionhandle.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeRequest {
    private String name;
    private String description;
}
