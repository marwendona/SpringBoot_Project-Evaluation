package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.primatec.evaluation.dto.EmployeeDetailDto;
import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.service.EvalService;

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

    @PostMapping("/data")
    public void loadFromExcel() throws Exception {
        evalService.loadFromExcel(FILE_PATH);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetailsById(@PathVariable Long id) {
        EmployeeDetails employeeDetails = evalService.getEmployeeDetailsById(id);
        return ResponseEntity.ok(employeeDetails);
    }
}
