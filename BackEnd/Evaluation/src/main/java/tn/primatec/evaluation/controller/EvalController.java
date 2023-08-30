package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.eval.Satisfaction;
import tn.primatec.evaluation.model.eval.Stability;
import tn.primatec.evaluation.model.eval.TechnicalEvaluation;
import tn.primatec.evaluation.service.EvalService;

import java.io.IOException;
import java.util.List;

import static tn.primatec.evaluation.application.ApplicationProperties.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/evals")
@CrossOrigin
public class EvalController {
    private final EvalService evalService;

    @Autowired
    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() throws Exception {
        String filePath = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";
        return evalService.loadEmployeesFromExcel(filePath);
    }

    @GetMapping("/satisfactions")
    public List<Satisfaction> getSatisfactions() throws IOException {
        String filePath = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";
        return evalService.loadSatisfactionsFromExcel(filePath);
    }

    @GetMapping("/stabilities")
    public List<Stability> getStabilities() throws IOException {
        String filePath = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";
        return evalService.loadStabilitiesFromExcel(filePath);
    }

    @GetMapping("/technical_evaluations")
    public List<TechnicalEvaluation> gettechnicalEvaluations() throws IOException {
        String filePath = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";
        return evalService.loadTechnicalEvaluationsFromExcel(filePath);
    }
}
