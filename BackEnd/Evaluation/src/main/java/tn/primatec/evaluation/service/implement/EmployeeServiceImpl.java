package tn.primatec.evaluation.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.adapter.EmployeeAdapter;
import tn.primatec.evaluation.dao.EmployeeRepository;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.exception.ResourceNotFoundException;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.service.EmployeeService;

import java.util.List;

import static tn.primatec.evaluation.adapter.EmployeeAdapter.toEmployeeDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDetails> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeAdapter::toEmployeeDetails)
                .toList();
    }

    @Override
    public EmployeeDetails getEmployee(long employeeId) {
        var employeeDto = findEmployeeById(employeeId);
        return toEmployeeDetails(employeeDto);
    }

    public EmployeeDto findEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        EmployeeDto employeeDtoFromDb = findEmployeeById(id);
        System.out.println(employeeDtoFromDb.toString());

        employeeDtoFromDb.setFirstName(employee.getFirstName());
        employeeDtoFromDb.setLastName(employee.getLastName());
        employeeDtoFromDb.setDepartment(employee.getDepartment());
        employeeDtoFromDb.setTeam(employee.getTeam());
        employeeDtoFromDb.setJobTitle(employee.getJobTitle());

        employeeRepository.save(employeeDtoFromDb);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
