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

    public static Stability toStability(StabilityDto stabilityDto) {
        var stability = new Stability();
        stability.setAreYouActivelyLookingForJobOffers(stabilityDto.getAreYouActivelyLookingForJobOffers());
        stability.setAreYouOpenToTechnica_sOffers(stabilityDto.getAreYouOpenToTechnica_sOffers()); // Assurez-vous que le nom de la méthode est correct

        return stability;
    }
}
