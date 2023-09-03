package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class Stability {
    private String areYouActivelyLookingForJobOffers;
    private String areYouOpenToTechnica_sOffers;

    public Stability() {
    }
}
