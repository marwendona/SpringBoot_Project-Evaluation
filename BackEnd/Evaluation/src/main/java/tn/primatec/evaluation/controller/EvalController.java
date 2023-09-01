package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.primatec.evaluation.dto.EmployeeDetailDto;
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
//    @GetMapping("/employees")
//    public List<Employee> getEmployees() throws Exception {
//        return evalService.loadEmployeesFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/satisfactions")
//    public List<Satisfaction> getSatisfactions() throws Exception {
//        return evalService.loadSatisfactionsFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/stabilities")
//    public List<Stability> getStabilities() throws Exception {
//        return evalService.loadStabilitiesFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/technical_evaluations")
//    public List<TechnicalEvaluation> getTechnicalEvaluations() throws Exception {
//        return evalService.loadTechnicalEvaluationsFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/objectives_and_proactivities")
//    public List<ObjectivesAndProactivity> getObjectivesAndProactivity() throws Exception {
//        return evalService.loadObjectivesAndProactivitiesFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/careers_and_trainings")
//    public List<CareerAndTrainings> getCareerAndTrainings() throws Exception {
//        return evalService.loadCareersAndTrainingsFromExcel(FILE_PATH);
//    }
//
//    @GetMapping("/yearly_evaluation")
//    public List<YearlyEvaluation> getYearlyEvaluation() throws Exception {
//        return evalService.loadYearlyEvaluationFromExcel(FILE_PATH);
//    }

    @PutMapping("/data")
    public void loadFromExcel() throws Exception {
        evalService.loadFromExcel(FILE_PATH);
    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<EmployeeDetailDto> getEmployeeById(@PathVariable Long employeeId) {
//        EmployeeDetailDto employeeDetailDto = evalService.getEmployeeById(employeeId);
//        return ResponseEntity.ok(employeeDetailDto);
//    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<EmployeeDto> getEmployeeDetails(@PathVariable Long employeeId) {
//        EmployeeDto employeeDetails = evalService.getEmployeeDetailsById(employeeId);
//        return ResponseEntity.ok(employeeDetails);
//    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
//        EmployeeDto employeeDto = evalService.getEmployeeByIdWithDetails(employeeId);
//        return ResponseEntity.ok(employeeDto);
//    }
}
