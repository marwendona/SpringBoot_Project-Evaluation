package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CareerAndTrainings {
    private String whichPathYouSeeItSuitableForYou;
    private String doYouHaveTargetRoleOrPosition;
    private String inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining;

    public CareerAndTrainings(String whichPathYouSeeItSuitableForYou, String doYouHaveTargetRoleOrPosition, String inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining) {
        this.whichPathYouSeeItSuitableForYou = whichPathYouSeeItSuitableForYou;
        this.doYouHaveTargetRoleOrPosition = doYouHaveTargetRoleOrPosition;
        this.inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining = inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining;
    }

    public CareerAndTrainings() {
    }
}
