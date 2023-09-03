package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class YearlyEvaluation {
    private float salaryIncrease;
    private String grade;
    private float accumulativeScore;
    private int scoreToReachNextGrade;
    private String satisfactionWithTheGrade;

    public YearlyEvaluation() {
    }
}
