package tn.primatec.evaluation.model.employee;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import tn.primatec.evaluation.model.eval.*;

import java.util.Date;

@Data
@Jacksonized
public class EmployeeDetails {
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
    private Satisfaction satisfaction;
    private Stability stability;
    private TechnicalEvaluation technicalEvaluation;
    private ObjectivesAndProactivity objectivesAndProactivity;
    private CareerAndTrainings careerAndTrainings;
    private YearlyEvaluation yearlyEvaluation;

    public EmployeeDetails() {
    }
}
