package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.model.employee.EmployeeSummary;
import tn.primatec.evaluation.service.EvalService;

import java.util.List;

import static tn.primatec.evaluation.application.ApplicationProperties.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/evals")
@CrossOrigin
public class EvalController {
    private final EvalService evalService;
    private static final String FILE_PATH = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";

    @Autowired
    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }

    @PostMapping("/employees")
    public void loadFromExcel(@RequestBody String filePath) throws Exception {
        evalService.loadFromExcel(filePath);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeSummary>> getAllEmployeesSummary() {
        List<EmployeeSummary> employeeSummaries = evalService.getAllEmployeesSummary();
        return ResponseEntity.ok(employeeSummaries);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetailsById(@PathVariable Long id) {
        EmployeeDetails employeeDetails = evalService.getEmployeeDetailsById(id);
        return ResponseEntity.ok(employeeDetails);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails updatedEmployee) {
        EmployeeDetails updatedDetails = evalService.updateEmployeeDetails(id, updatedEmployee);
        return ResponseEntity.ok(updatedDetails);
    }
}
