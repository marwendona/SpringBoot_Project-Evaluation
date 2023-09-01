package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.ObjectivesAndProactivityDto;
import tn.primatec.evaluation.model.eval.ObjectivesAndProactivity;

public class ObjectivesAndProactivityAdapter {
    public static ObjectivesAndProactivityDto toObjectivesAndProactivityDto(ObjectivesAndProactivity objectivesAndProactivity) {
        var objectivesAndProactivityDto = new ObjectivesAndProactivityDto();
        objectivesAndProactivityDto.setLastYearObjectives(objectivesAndProactivity.getLastYearObjectives());
        objectivesAndProactivityDto.setAchievementsForLastYear(objectivesAndProactivity.getAchievementsForLastYear());
        objectivesAndProactivityDto.setTargetsForNextYear(objectivesAndProactivity.getTargetsForNextYear());
        objectivesAndProactivityDto.setKeysAndToolsForTargetsSuccess(objectivesAndProactivity.getKeysAndToolsForTargetsSuccess());
        objectivesAndProactivityDto.setDidYouEverRaise_HighlightAProblem(objectivesAndProactivity.getDidYouEverRaise_HighlightAProblem());
        objectivesAndProactivityDto.setDoYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask(objectivesAndProactivity.getDoYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask());

        return objectivesAndProactivityDto;
    }
}
