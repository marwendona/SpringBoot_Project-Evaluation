package tn.primatec.evaluation.service;

import tn.primatec.evaluation.model.employee.EmployeeDetails;

public interface EvalService {
    void loadFromExcel(String filePath) throws Exception;
    EmployeeDetails getEmployeeDetailsById(Long id);
}
