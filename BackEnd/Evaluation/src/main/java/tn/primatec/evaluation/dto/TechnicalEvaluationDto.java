package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "technical_evaluation")
@Data
public class TechnicalEvaluationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teamLeadScoreTechnicalKnowledgeAndExpertise")
    private int teamLeadScoreTechnicalKnowledgeAndExpertise;

    @Column(name = "developerScoreTechnicalKnowledgeAndExpertise")
    private int developerScoreTechnicalKnowledgeAndExpertise;

    @Column(name = "teamLeadScoreQualityOfWork")
    private int teamLeadScoreQualityOfWork;

    @Column(name = "developerScoreQualityOfWork")
    private int developerScoreQualityOfWork;

    @Column(name = "teamLeadScoreProactivity")
    private int teamLeadScoreProactivity;

    @Column(name = "developerScoreProactivity")
    private int developerScoreProactivity;

    @Column(name = "teamLeadScoreSoftSkills")
    private int teamLeadScoreSoftSkills;

    @Column(name = "developerScoreSoftSkills")
    private int developerScoreSoftSkills;

    @Column(name = "teamLeadScoreDisciplinary_RespectOfProcess_Punctuality")
    private int teamLeadScoreDisciplinary_RespectOfProcess_Punctuality;

    @Column(name = "developerScoreDisciplinary_RespectOfProcess_Punctuality")
    private int developerScoreDisciplinary_RespectOfProcess_Punctuality;

    @Column(name = "teamLeadTotalScore")
    private float teamLeadTotalScore;

    @Column(name = "developerTotalScore")
    private float developerTotalScore;

    @OneToOne(mappedBy = "technicalEvaluation")
    private EmployeeDto employee;
}
