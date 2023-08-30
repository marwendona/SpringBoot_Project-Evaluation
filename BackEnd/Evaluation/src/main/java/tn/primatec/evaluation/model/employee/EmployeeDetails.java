package tn.primatec.evaluation.model.employee;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
@Jacksonized
public class EmployeeDetails {
    private long id;
    private String department;
    private String team;
    private String nameAndSurname;
    private String jobTitle;
    private Date employmentDate;
    private String employmentType;
    private String grade;
    private double lastEvaluationScore;
    private double currentEvaluationScore;
    private Date reviewDate;
    private String reviewer;
}
