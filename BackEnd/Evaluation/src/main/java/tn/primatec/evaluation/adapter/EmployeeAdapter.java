package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.Employee;

public class EmployeeAdapter {
    public static EmployeeDto toEmployeeDto(Employee employee){
        var employeeDto = new EmployeeDto();
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setTeam(employee.getTeam());
        employeeDto.setNameAndSurname(employee.getNameAndSurname());
        employeeDto.setJobTitle(employee.getJobTitle());
        employeeDto.setEmploymentDate(employee.getEmploymentDate());
        employeeDto.setEmploymentType(employee.getEmploymentType());
        employeeDto.setGrade(employee.getGrade());
        employeeDto.setLastEvaluationScore(employee.getLastEvaluationScore());
        employeeDto.setCurrentEvaluationScore(employee.getCurrentEvaluationScore());
        employeeDto.setReviewDate(employee.getReviewDate());
        employeeDto.setReviewer(employee.getReviewer());

        return employeeDto;
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        var employee = new Employee();
        employee.setDepartment(employeeDto.getDepartment());
        employee.setTeam(employeeDto.getTeam());
        employee.setNameAndSurname(employeeDto.getNameAndSurname());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setEmploymentDate(employeeDto.getEmploymentDate());
        employee.setEmploymentType(employeeDto.getEmploymentType());
        employee.setGrade(employeeDto.getGrade());
        employee.setLastEvaluationScore(employeeDto.getLastEvaluationScore());
        employee.setCurrentEvaluationScore(employeeDto.getCurrentEvaluationScore());
        employee.setReviewDate(employeeDto.getReviewDate());
        employee.setReviewer(employeeDto.getReviewer());

        return employee;
    }
}
