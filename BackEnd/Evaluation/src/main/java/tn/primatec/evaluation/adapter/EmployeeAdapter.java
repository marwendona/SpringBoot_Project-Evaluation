package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.employee.EmployeeDetails;

public class EmployeeAdapter {
    public static EmployeeDetails toEmployeeDetails(EmployeeDto employeeDto) {
        return EmployeeDetails.builder().id(employeeDto.getId())
                .department(employeeDto.getDepartment())
                .team(employeeDto.getTeam())
                .nameAndSurname(employeeDto.getNameAndSurname())
                .jobTitle(employeeDto.getJobTitle())
                .employmentDate(employeeDto.getEmploymentDate())
                .employmentType(employeeDto.getEmploymentType())
                .grade(employeeDto.getGrade())
                .lastEvaluationScore((employeeDto.getLastEvaluationScore()))
                .currentEvaluationScore(employeeDto.getCurrentEvaluationScore())
                .reviewDate(employeeDto.getReviewDate())
                .reviewer(employeeDto.getReviewer())
                .build();
    }
}
