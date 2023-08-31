package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.primatec.evaluation.model.Employee;
import tn.primatec.evaluation.model.eval.*;
import tn.primatec.evaluation.service.EvalService;

import java.io.IOException;
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

    @GetMapping("/employees")
    public List<Employee> getEmployees() throws Exception {
        return evalService.loadEmployeesFromExcel(FILE_PATH);
    }

    @GetMapping("/satisfactions")
    public List<Satisfaction> getSatisfactions() throws IOException {
        return evalService.loadSatisfactionsFromExcel(FILE_PATH);
    }

    @GetMapping("/stabilities")
    public List<Stability> getStabilities() throws IOException {
        return evalService.loadStabilitiesFromExcel(FILE_PATH);
    }

    @GetMapping("/technical_evaluations")
    public List<TechnicalEvaluation> getTechnicalEvaluations() throws IOException {
        return evalService.loadTechnicalEvaluationsFromExcel(FILE_PATH);
    }

    @GetMapping("/objectives_and_proactivities")
    public List<ObjectivesAndProactivity> getObjectivesAndProactivity() throws IOException {
        return evalService.loadObjectivesAndProactivitiesFromExcel(FILE_PATH);
    }

    @GetMapping("/careers_and_trainings")
    public List<CareerAndTrainings> getCareerAndTrainings() throws IOException {
        return evalService.loadCareersAndTrainingsFromExcel(FILE_PATH);
    }

    @GetMapping("/yearly_evaluation")
    public List<YearlyEvaluation> getYearlyEvaluation() throws IOException {
        return evalService.loadYearlyEvaluationFromExcel(FILE_PATH);
    }
}
