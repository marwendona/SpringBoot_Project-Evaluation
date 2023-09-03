package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class CareerAndTrainings {
    private String whichPathYouSeeItSuitableForYou;
    private String doYouHaveTargetRoleOrPosition;
    private String inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining;

    public CareerAndTrainings() {
    }
}
