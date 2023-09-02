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

    public static ObjectivesAndProactivity toObjectivesAndProactivity(ObjectivesAndProactivityDto objectivesAndProactivityDto) {
        var objectivesAndProactivity = new ObjectivesAndProactivity();
        objectivesAndProactivity.setLastYearObjectives(objectivesAndProactivityDto.getLastYearObjectives());
        objectivesAndProactivity.setAchievementsForLastYear(objectivesAndProactivityDto.getAchievementsForLastYear());
        objectivesAndProactivity.setTargetsForNextYear(objectivesAndProactivityDto.getTargetsForNextYear());
        objectivesAndProactivity.setKeysAndToolsForTargetsSuccess(objectivesAndProactivityDto.getKeysAndToolsForTargetsSuccess());
        objectivesAndProactivity.setDidYouEverRaise_HighlightAProblem(objectivesAndProactivityDto.getDidYouEverRaise_HighlightAProblem());
        objectivesAndProactivity.setDoYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask(objectivesAndProactivityDto.getDoYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask());

        return objectivesAndProactivity;
    }
}
