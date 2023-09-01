package tn.primatec.evaluation.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@Builder
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

    public Employee(String department, String team, String nameAndSurname, String jobTitle, Date employmentDate, String employmentType, String grade, double lastEvaluationScore, double currentEvaluationScore, Date reviewDate, String reviewer) {
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
    }

    public Employee() {
    }
}