package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ObjectivesAndProactivity {
    private String lastYearObjectives;
    private String achievementsForLastYear;
    private String targetsForNextYear;
    private String keysAndToolsForTargetsSuccess;
    private String didYouEverRaise_HighlightAProblem;
    private String doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask;

    public ObjectivesAndProactivity(String lastYearObjectives, String achievementsForLastYear, String targetsForNextYear, String keysAndToolsForTargetsSuccess, String didYouEverRaise_HighlightAProblem, String doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask) {
        this.lastYearObjectives = lastYearObjectives;
        this.achievementsForLastYear = achievementsForLastYear;
        this.targetsForNextYear = targetsForNextYear;
        this.keysAndToolsForTargetsSuccess = keysAndToolsForTargetsSuccess;
        this.didYouEverRaise_HighlightAProblem = didYouEverRaise_HighlightAProblem;
        this.doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask = doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask;
    }

    public ObjectivesAndProactivity() {
    }
}
