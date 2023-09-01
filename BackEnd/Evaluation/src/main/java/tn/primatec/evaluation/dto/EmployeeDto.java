package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department")
    private String department;

    @Column(name = "team")
    private String team;

    @Column(name = "nameAndSurname")
    private String nameAndSurname;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "employmentDate")
    private Date employmentDate;

    @Column(name = "employmentType")
    private String employmentType;

    @Column(name = "grade")
    private String grade;

    @Column(name = "lastEvaluationScore")
    private double lastEvaluationScore;

    @Column(name = "currentEvaluationScore")
    private double currentEvaluationScore;

    @Column(name = "reviewDate")
    private Date reviewDate;

    @Column(name = "reviewer")
    private String reviewer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "satisfaction_id")
    private SatisfactionDto satisfaction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stability_id")
    private StabilityDto stability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_evaluation_id")
    private TechnicalEvaluationDto technicalEvaluation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objectives_and_proactivity_id")
    private ObjectivesAndProactivityDto objectivesAndProactivity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "career_and_trainings_id")
    private CareerAndTrainingsDto careerAndTrainings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "yearly_evaluation_id")
    private YearlyEvaluationDto yearlyEvaluation;
}
