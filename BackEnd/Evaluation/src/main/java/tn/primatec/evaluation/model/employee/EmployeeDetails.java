package tn.primatec.evaluation.model.employee;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import tn.primatec.evaluation.model.eval.*;

import java.util.Date;

@Data
@Builder
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

    public EmployeeDetails(String department, String team, String nameAndSurname, String jobTitle, Date employmentDate, String employmentType, String grade, double lastEvaluationScore, double currentEvaluationScore, Date reviewDate, String reviewer, Satisfaction satisfaction, Stability stability, TechnicalEvaluation technicalEvaluation, ObjectivesAndProactivity objectivesAndProactivity, CareerAndTrainings careerAndTrainings, YearlyEvaluation yearlyEvaluation) {
        this.department = department;
        this.team = team;
        this.nameAndSurname = nameAndSurname;
        this.jobTitle = jobTitle;
        this.employmentDate = employmentDate;
        this.employmentType = employmentType;
        this.grade = grade;
        this.lastEvaluationScore = lastEvaluationScore;
        this.currentEvaluationScore = currentEvaluationScore;
        this.reviewDate = reviewDate;
        this.reviewer = reviewer;
        this.satisfaction = satisfaction;
        this.stability = stability;
        this.technicalEvaluation = technicalEvaluation;
        this.objectivesAndProactivity = objectivesAndProactivity;
        this.careerAndTrainings = careerAndTrainings;
        this.yearlyEvaluation = yearlyEvaluation;
    }

    public EmployeeDetails() {
    }
}
