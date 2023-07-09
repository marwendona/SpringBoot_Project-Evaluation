package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.service.EmployeeService;

import java.util.List;

import static tn.primatec.evaluation.application.ApplicationProperties.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/employees")
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDetails> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeDetails getEmployee(@PathVariable long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping({"/{employeeId}/update"})
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(employeeService.findEmployeeById(employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
