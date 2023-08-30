package tn.primatec.evaluation.service;

import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.eval.ObjectivesAndProactivity;
import tn.primatec.evaluation.model.eval.Satisfaction;
import tn.primatec.evaluation.model.eval.Stability;
import tn.primatec.evaluation.model.eval.TechnicalEvaluation;

import java.io.IOException;
import java.util.List;

public interface EvalService {
    List<Employee> loadEmployeesFromExcel(String filePath) throws Exception;
    List<Satisfaction> loadSatisfactionsFromExcel(String filePath) throws IOException;
    List<Stability> loadStabilitiesFromExcel(String filePath) throws IOException;
    List<TechnicalEvaluation> loadTechnicalEvaluationsFromExcel(String filePath) throws IOException;
    List<ObjectivesAndProactivity> loadObjectivesAndProactivitiesFromExcel(String filePath) throws IOException;
}
