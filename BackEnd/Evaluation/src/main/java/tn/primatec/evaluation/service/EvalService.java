package tn.primatec.evaluation.service;

import tn.primatec.evaluation.dto.EmployeeDetailDto;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.Employee;
import tn.primatec.evaluation.model.eval.*;

import java.io.IOException;
import java.util.List;

public interface EvalService {
//    List<Employee> loadEmployeesFromExcel(String filePath) throws Exception;
//    List<Satisfaction> loadSatisfactionsFromExcel(String filePath) throws Exception;
//    List<Stability> loadStabilitiesFromExcel(String filePath) throws Exception;
//    List<TechnicalEvaluation> loadTechnicalEvaluationsFromExcel(String filePath) throws Exception;
//    List<ObjectivesAndProactivity> loadObjectivesAndProactivitiesFromExcel(String filePath) throws Exception;
//    List<CareerAndTrainings> loadCareersAndTrainingsFromExcel(String filePath) throws Exception;
//    List<YearlyEvaluation> loadYearlyEvaluationFromExcel(String filePath) throws Exception;
    void loadFromExcel(String filePath) throws Exception;
//    EmployeeDto getEmployeeDetailsById(Long employeeId);
//    EmployeeDto getEmployeeByIdWithDetails(Long employeeId);
//    EmployeeDetailDto getEmployeeById(Long employeeId);
}
