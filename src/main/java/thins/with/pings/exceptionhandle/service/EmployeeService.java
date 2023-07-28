package thins.with.pings.exceptionhandle.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thins.with.pings.exceptionhandle.entity.Employee;
import thins.with.pings.exceptionhandle.exception.ResourceCreationFailedException;
import thins.with.pings.exceptionhandle.exception.ResourceNotFoundException;
import thins.with.pings.exceptionhandle.repository.EmployeeRepository;
import thins.with.pings.exceptionhandle.request.EmployeeRequest;
import thins.with.pings.exceptionhandle.response.EmployeeResponse;
import thins.with.pings.exceptionhandle.response.Response;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    public Response saveEmployee(EmployeeRequest employeeRequest) throws ResourceCreationFailedException {
        Response response = new Response();
        try {
            Employee employee = buildEmployee(employeeRequest);
            employeeRepository.save(employee);
            response.setStatus("success");
            response.setMessage("employee create successfully");
            response.setData(EmployeeResponse.builder().employeeId(employee.getEmployeeId()).build());
        }
        catch (Exception e){
            throw new ResourceCreationFailedException("employee creation failed. try again later");
        }
        return response;
    }

    private Employee buildEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .employeeName(employeeRequest.getName())
                .employeeDescription(employeeRequest.getDescription())
                .build();
    }

    public Response getEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("employee not found for employee id : "+employeeId));

        EmployeeResponse employeeResponse = buildEmployeeResponse(employee);
        Response response = new Response();
        response.setStatus("success");
        response.setMessage("employee get successfully");
        response.setData(employeeResponse);

        return response;
    }

    private EmployeeResponse buildEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .employeeDescription(employee.getEmployeeDescription())
                .build();
    }
}
