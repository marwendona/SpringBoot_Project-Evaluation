package tn.primatec.evaluation.service;

import tn.primatec.evaluation.model.employee.EmployeeDetails;
import tn.primatec.evaluation.model.employee.EmployeeSummary;

import java.util.List;

public interface EvalService {
    void loadFromExcel(String filePath) throws Exception;
    EmployeeDetails getEmployeeDetailsById(Long id);
    List<EmployeeSummary> getAllEmployeesSummary();
    EmployeeDetails updateEmployeeDetails(Long id, EmployeeDetails updatedEmployee);
}
