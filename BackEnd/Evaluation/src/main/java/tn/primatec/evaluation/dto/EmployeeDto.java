package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private UserDto userDto;

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
}
