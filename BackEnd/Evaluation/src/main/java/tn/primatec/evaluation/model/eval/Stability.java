package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Stability {
    private String areYouActivelyLookingForJobOffers;
    private String areYouOpenToTechnica_sOffers;

    public Stability(String areYouActivelyLookingForJobOffers, String areYouOpenToTechnica_sOffers) {
        this.areYouActivelyLookingForJobOffers = areYouActivelyLookingForJobOffers;
        this.areYouOpenToTechnica_sOffers = areYouOpenToTechnica_sOffers;
    }

    public Stability() {
    }
}
