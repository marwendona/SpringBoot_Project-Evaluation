package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
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

    public TechnicalEvaluation() {
    }

    public float getTeamLeadTotalScore() {
        return (teamLeadScoreTechnicalKnowledgeAndExpertise + teamLeadScoreQualityOfWork
                + teamLeadScoreProactivity + teamLeadScoreSoftSkills
                + teamLeadScoreDisciplinary_RespectOfProcess_Punctuality) / 5.0f;
    }
    public float getDeveloperTotalScore() {
        return (developerScoreTechnicalKnowledgeAndExpertise + developerScoreQualityOfWork
                + developerScoreProactivity + developerScoreSoftSkills
                + developerScoreDisciplinary_RespectOfProcess_Punctuality) / 5.0f;
    }
}
