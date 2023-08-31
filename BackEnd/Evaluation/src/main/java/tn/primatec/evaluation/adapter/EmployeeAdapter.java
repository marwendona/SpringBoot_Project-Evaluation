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

//    public static Employee toEmployee(EmployeeDto employeeDto) {
//        var employee = new Employee();
//        return employee.builder().department(employeeDto.getDepartment())
//                .team(employeeDto.getTeam())
//                .nameAndSurname(employeeDto.getNameAndSurname())
//                .jobTitle(employeeDto.getJobTitle())
//                .employmentDate(employeeDto.getEmploymentDate())
//                .employmentType(employeeDto.getEmploymentType())
//                .grade(employeeDto.getGrade())
//                .lastEvaluationScore((employeeDto.getLastEvaluationScore()))
//                .currentEvaluationScore(employeeDto.getCurrentEvaluationScore())
//                .reviewDate(employeeDto.getReviewDate())
//                .reviewer(employeeDto.getReviewer())
//                .build();
//    }
}
