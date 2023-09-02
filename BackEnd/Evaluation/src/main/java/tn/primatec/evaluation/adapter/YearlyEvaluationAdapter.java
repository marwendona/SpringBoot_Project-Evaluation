package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.YearlyEvaluationDto;
import tn.primatec.evaluation.model.eval.YearlyEvaluation;

public class YearlyEvaluationAdapter {
    public static YearlyEvaluationDto toYearlyEvaluationDto(YearlyEvaluation yearlyEvaluation) {
        var yearlyEvaluationDto = new YearlyEvaluationDto();
        yearlyEvaluationDto.setSalaryIncrease(yearlyEvaluation.getSalaryIncrease());
        yearlyEvaluationDto.setGrade(yearlyEvaluation.getGrade());
        yearlyEvaluationDto.setAccumulativeScore(yearlyEvaluation.getAccumulativeScore());
        yearlyEvaluationDto.setScoreToReachNextGrade(yearlyEvaluation.getScoreToReachNextGrade());
        yearlyEvaluationDto.setSatisfactionWithTheGrade(yearlyEvaluation.getSatisfactionWithTheGrade());

        return yearlyEvaluationDto;
    }

    public static YearlyEvaluation toYearlyEvaluation(YearlyEvaluationDto yearlyEvaluationDto) {
        var yearlyEvaluation = new YearlyEvaluation();
        yearlyEvaluation.setSalaryIncrease(yearlyEvaluationDto.getSalaryIncrease());
        yearlyEvaluation.setGrade(yearlyEvaluationDto.getGrade());
        yearlyEvaluation.setAccumulativeScore(yearlyEvaluationDto.getAccumulativeScore());
        yearlyEvaluation.setScoreToReachNextGrade(yearlyEvaluationDto.getScoreToReachNextGrade());
        yearlyEvaluation.setSatisfactionWithTheGrade(yearlyEvaluationDto.getSatisfactionWithTheGrade());

        return yearlyEvaluation;
    }
}
