package tn.primatec.evaluation.model.employee;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class EmployeeSummary {
    private Long id;
    private String department;
    private String team;
    private String nameAndSurname;
}
