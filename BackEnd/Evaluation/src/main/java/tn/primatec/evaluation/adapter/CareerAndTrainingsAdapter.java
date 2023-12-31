package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.CareerAndTrainingsDto;
import tn.primatec.evaluation.model.eval.CareerAndTrainings;

public class CareerAndTrainingsAdapter {
    public static CareerAndTrainingsDto toCareerAndTrainingsDto(CareerAndTrainings careerAndTrainings){
        var careerAndTrainingsDto = new CareerAndTrainingsDto();
        careerAndTrainingsDto.setWhichPathYouSeeItSuitableForYou(careerAndTrainings.getWhichPathYouSeeItSuitableForYou());
        careerAndTrainingsDto.setDoYouHaveTargetRoleOrPosition(careerAndTrainings.getDoYouHaveTargetRoleOrPosition());
        careerAndTrainingsDto.setInOrderToReachYourObjective_RoleWhatDoYouRequestForTraining(careerAndTrainings.getInOrderToReachYourObjective_RoleWhatDoYouRequestForTraining());

        return careerAndTrainingsDto;
    }

    public static CareerAndTrainings toCareerAndTrainings(CareerAndTrainingsDto careerAndTrainingsDto) {
        var careerAndTrainings = new CareerAndTrainings();
        careerAndTrainings.setWhichPathYouSeeItSuitableForYou(careerAndTrainingsDto.getWhichPathYouSeeItSuitableForYou());
        careerAndTrainings.setDoYouHaveTargetRoleOrPosition(careerAndTrainingsDto.getDoYouHaveTargetRoleOrPosition());
        careerAndTrainings.setInOrderToReachYourObjective_RoleWhatDoYouRequestForTraining(careerAndTrainingsDto.getInOrderToReachYourObjective_RoleWhatDoYouRequestForTraining());

        return careerAndTrainings;
    }
}
