package tn.primatec.evaluation.model.employee;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class EmployeeDetails {
    private long id;
    private String firstName;
    private String lastName;
    private String department;
    private String team;
    private String jobTitle;
}
