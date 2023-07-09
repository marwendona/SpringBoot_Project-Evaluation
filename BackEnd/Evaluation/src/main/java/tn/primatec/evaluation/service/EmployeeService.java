package tn.primatec.evaluation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.employee.EmployeeDetails;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDetails> getEmployees();
    EmployeeDetails getEmployee(long employeeId);
    EmployeeDto findEmployeeById(long employeeId);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(long employeeId);
}
