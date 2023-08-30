package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class YearlyEvaluation {
    private float salaryIncrease;
    private String grade;
    private float accumulativeScore;
    private int scoreToReachNextGrade;
    private String satisfactionWithTheGrade;

    public YearlyEvaluation(float salaryIncrease, String grade, float accumulativeScore, int scoreToReachNextGrade, String satisfactionWithTheGrade) {
        this.salaryIncrease = salaryIncrease;
        this.grade = grade;
        this.accumulativeScore = accumulativeScore;
        this.scoreToReachNextGrade = scoreToReachNextGrade;
        this.satisfactionWithTheGrade = satisfactionWithTheGrade;
    }

    public YearlyEvaluation() {
    }
}
