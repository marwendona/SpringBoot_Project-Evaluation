package tn.primatec.evaluation.model.eval;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class Satisfaction {
    private int teamAtmosphere;
    private int workload;
    private int compagnySatisfactionScale;
    private int satisfactionWithTechnicalLeader;
    private int satisfactionWithTeamLeader;
    private int satisfactionWithProject;
    private int satisfactionWithGroupLeader;
    private int satisfactionWithTeamBuilding;
    private int satisfactionWithCareerPath;
    private int didTheCompagnySatisfyYourAmbitions;
    private float totalScore;

    public Satisfaction() {
    }

    public float getTotalScore() {
        return (teamAtmosphere + workload + compagnySatisfactionScale
                + satisfactionWithTechnicalLeader + satisfactionWithTeamLeader + satisfactionWithProject
                + satisfactionWithGroupLeader + satisfactionWithTeamBuilding
                + satisfactionWithCareerPath + didTheCompagnySatisfyYourAmbitions) / 10.0f;
    }
}
