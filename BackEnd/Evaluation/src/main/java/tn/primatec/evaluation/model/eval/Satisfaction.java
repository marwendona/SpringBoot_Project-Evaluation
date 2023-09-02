package tn.primatec.evaluation.model.eval;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
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

    public Satisfaction(int teamAtmosphere, int workload, int compagnySatisfactionScale, int satisfactionWithTechnicalLeader, int satisfactionWithTeamLeader, int satisfactionWithProject, int satisfactionWithGroupLeader, int satisfactionWithTeamBuilding, int satisfactionWithCareerPath, int didTheCompagnySatisfyYourAmbitions, float totalScore) {
        this.teamAtmosphere = teamAtmosphere;
        this.workload = workload;
        this.compagnySatisfactionScale = compagnySatisfactionScale;
        this.satisfactionWithTechnicalLeader = satisfactionWithTechnicalLeader;
        this.satisfactionWithTeamLeader = satisfactionWithTeamLeader;
        this.satisfactionWithProject = satisfactionWithProject;
        this.satisfactionWithGroupLeader = satisfactionWithGroupLeader;
        this.satisfactionWithTeamBuilding = satisfactionWithTeamBuilding;
        this.satisfactionWithCareerPath = satisfactionWithCareerPath;
        this.didTheCompagnySatisfyYourAmbitions = didTheCompagnySatisfyYourAmbitions;
        totalScore = (teamAtmosphere + workload + compagnySatisfactionScale
        + satisfactionWithTechnicalLeader + satisfactionWithTeamLeader + satisfactionWithProject
                + satisfactionWithGroupLeader + satisfactionWithTeamBuilding
                + satisfactionWithCareerPath + didTheCompagnySatisfyYourAmbitions) / 10.0f;
    }

    public Satisfaction() {
    }
}
