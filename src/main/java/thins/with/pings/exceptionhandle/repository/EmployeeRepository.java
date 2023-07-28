package thins.with.pings.exceptionhandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thins.with.pings.exceptionhandle.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
