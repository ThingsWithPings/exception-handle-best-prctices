package thins.with.pings.exceptionhandle.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponse {
    private Long employeeId;
    private String employeeName;
    private String employeeDescription;
}
