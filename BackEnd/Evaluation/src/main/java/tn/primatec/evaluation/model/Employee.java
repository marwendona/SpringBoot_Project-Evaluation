package tn.primatec.evaluation.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String team;
    private String jobTitle;
}
