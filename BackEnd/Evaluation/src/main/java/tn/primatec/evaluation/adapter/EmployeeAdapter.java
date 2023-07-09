package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.employee.EmployeeDetails;

public class EmployeeAdapter {
    public static EmployeeDetails toEmployeeDetails(EmployeeDto employeeDto) {
        return EmployeeDetails.builder().id(employeeDto.getId()).firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName()).department(employeeDto.getDepartment())
                .team(employeeDto.getTeam()).jobTitle(employeeDto.getJobTitle()).build();
    }
}
