package tn.primatec.evaluation.model.employee;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Jacksonized
public class Employee {
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

    public Employee() {
    }
}
