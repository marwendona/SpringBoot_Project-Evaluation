package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.StabilityDto;
import tn.primatec.evaluation.model.eval.Stability;

public class StabilityAdapter {
    public static StabilityDto toStabilityDto(Stability stability) {
        var stabilityDto = new StabilityDto();
        stabilityDto.setAreYouActivelyLookingForJobOffers(stability.getAreYouActivelyLookingForJobOffers());
        stabilityDto.setAreYouOpenToTechnica_sOffers(stability.getAreYouOpenToTechnica_sOffers());

        return stabilityDto;
    }
}
