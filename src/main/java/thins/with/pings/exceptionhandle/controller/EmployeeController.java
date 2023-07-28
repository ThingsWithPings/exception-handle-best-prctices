package thins.with.pings.exceptionhandle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thins.with.pings.exceptionhandle.exception.ResourceCreationFailedException;
import thins.with.pings.exceptionhandle.request.EmployeeRequest;
import thins.with.pings.exceptionhandle.response.Response;
import thins.with.pings.exceptionhandle.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public Response saveEmployee(@RequestBody EmployeeRequest employeeRequest) throws ResourceCreationFailedException {
        return employeeService.saveEmployee(employeeRequest);
    }
}
