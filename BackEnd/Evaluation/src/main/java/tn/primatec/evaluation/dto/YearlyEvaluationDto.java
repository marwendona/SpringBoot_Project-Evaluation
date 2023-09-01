package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "yearly_evaluation")
@Data
public class YearlyEvaluationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salaryIncrease")
    private float salaryIncrease;

    @Column(name = "grade")
    private String grade;

    @Column(name = "accumulativeScore")
    private float accumulativeScore;

    @Column(name = "scoreToReachNextGrade")
    private int scoreToReachNextGrade;

    @Column(name = "satisfactionWithTheGrade")
    private String satisfactionWithTheGrade;

    @OneToOne(mappedBy = "yearlyEvaluation")
    private EmployeeDto employee;
}
