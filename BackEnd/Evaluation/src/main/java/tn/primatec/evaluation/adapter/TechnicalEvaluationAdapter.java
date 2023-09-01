package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.TechnicalEvaluationDto;
import tn.primatec.evaluation.model.eval.TechnicalEvaluation;

public class TechnicalEvaluationAdapter {
    public static TechnicalEvaluationDto toTechnicalEvaluationDto(TechnicalEvaluation technicalEvaluation) {
        var technicalEvaluationDto = new TechnicalEvaluationDto();
        technicalEvaluationDto.setTeamLeadScoreTechnicalKnowledgeAndExpertise(technicalEvaluation.getTeamLeadScoreTechnicalKnowledgeAndExpertise());
        technicalEvaluationDto.setDeveloperScoreTechnicalKnowledgeAndExpertise(technicalEvaluation.getDeveloperScoreTechnicalKnowledgeAndExpertise());
        technicalEvaluationDto.setTeamLeadScoreQualityOfWork(technicalEvaluation.getTeamLeadScoreQualityOfWork());
        technicalEvaluationDto.setDeveloperScoreQualityOfWork(technicalEvaluation.getDeveloperScoreQualityOfWork());
        technicalEvaluationDto.setTeamLeadScoreProactivity(technicalEvaluation.getTeamLeadScoreProactivity());
        technicalEvaluationDto.setDeveloperScoreProactivity(technicalEvaluation.getDeveloperScoreProactivity());
        technicalEvaluationDto.setTeamLeadScoreSoftSkills(technicalEvaluation.getTeamLeadScoreSoftSkills());
        technicalEvaluationDto.setDeveloperScoreSoftSkills(technicalEvaluation.getDeveloperScoreSoftSkills());
        technicalEvaluationDto.setTeamLeadScoreDisciplinary_RespectOfProcess_Punctuality(technicalEvaluation.getTeamLeadScoreDisciplinary_RespectOfProcess_Punctuality());
        technicalEvaluationDto.setDeveloperScoreDisciplinary_RespectOfProcess_Punctuality(technicalEvaluation.getDeveloperScoreDisciplinary_RespectOfProcess_Punctuality());

        return technicalEvaluationDto;
    }
}
