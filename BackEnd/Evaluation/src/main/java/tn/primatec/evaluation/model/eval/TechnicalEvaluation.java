package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class TechnicalEvaluation {
    private int teamLeadScoreTechnicalKnowledgeAndExpertise;
    private int developerScoreTechnicalKnowledgeAndExpertise;
    private int teamLeadScoreQualityOfWork;
    private int developerScoreQualityOfWork;
    private int teamLeadScoreProactivity;
    private int developerScoreProactivity;
    private int teamLeadScoreSoftSkills;
    private int developerScoreSoftSkills;
    private int teamLeadScoreDisciplinary_RespectOfProcess_Punctuality;
    private int developerScoreDisciplinary_RespectOfProcess_Punctuality;
    private float teamLeadTotalScore;
    private float developerTotalScore;

    public TechnicalEvaluation(int teamLeadScoreTechnicalKnowledgeAndExpertise, int developerScoreTechnicalKnowledgeAndExpertise, int teamLeadScoreQualityOfWork, int developerScoreQualityOfWork, int teamLeadScoreProactivity, int developerScoreProactivity, int teamLeadScoreSoftSkills, int developerScoreSoftSkills, int teamLeadScoreDisciplinary_RespectOfProcess_Punctuality, int developerScoreDisciplinary_RespectOfProcess_Punctuality, float teamLeadTotalScore, float developerTotalScore) {
        this.teamLeadScoreTechnicalKnowledgeAndExpertise = teamLeadScoreTechnicalKnowledgeAndExpertise;
        this.developerScoreTechnicalKnowledgeAndExpertise = developerScoreTechnicalKnowledgeAndExpertise;
        this.teamLeadScoreQualityOfWork = teamLeadScoreQualityOfWork;
        this.developerScoreQualityOfWork = developerScoreQualityOfWork;
        this.teamLeadScoreProactivity = teamLeadScoreProactivity;
        this.developerScoreProactivity = developerScoreProactivity;
        this.teamLeadScoreSoftSkills = teamLeadScoreSoftSkills;
        this.developerScoreSoftSkills = developerScoreSoftSkills;
        this.teamLeadScoreDisciplinary_RespectOfProcess_Punctuality = teamLeadScoreDisciplinary_RespectOfProcess_Punctuality;
        this.developerScoreDisciplinary_RespectOfProcess_Punctuality = developerScoreDisciplinary_RespectOfProcess_Punctuality;
        this.teamLeadTotalScore = teamLeadTotalScore;
        this.developerTotalScore = developerTotalScore;
    }

    public TechnicalEvaluation() {
    }
}
