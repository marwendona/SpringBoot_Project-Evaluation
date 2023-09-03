package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class ObjectivesAndProactivity {
    private String lastYearObjectives;
    private String achievementsForLastYear;
    private String targetsForNextYear;
    private String keysAndToolsForTargetsSuccess;
    private String didYouEverRaise_HighlightAProblem;
    private String doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask;

    public ObjectivesAndProactivity() {
    }
}
