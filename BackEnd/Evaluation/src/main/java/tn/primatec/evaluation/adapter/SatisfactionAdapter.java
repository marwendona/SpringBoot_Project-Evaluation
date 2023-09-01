package tn.primatec.evaluation.adapter;

import tn.primatec.evaluation.dto.SatisfactionDto;
import tn.primatec.evaluation.model.eval.Satisfaction;

public class SatisfactionAdapter {
    public static SatisfactionDto toSatisfactionDto(Satisfaction satisfaction) {
        var satisfactionDto = new SatisfactionDto();
        satisfactionDto.setTeamAtmosphere(satisfaction.getTeamAtmosphere());
        satisfactionDto.setWorkload(satisfaction.getWorkload());
        satisfactionDto.setCompagnySatisfactionScale(satisfaction.getCompagnySatisfactionScale());
        satisfactionDto.setSatisfactionWithTechnicalLeader(satisfaction.getSatisfactionWithTechnicalLeader());
        satisfactionDto.setSatisfactionWithTeamLeader(satisfaction.getSatisfactionWithTeamLeader());
        satisfactionDto.setSatisfactionWithProject(satisfaction.getSatisfactionWithProject());
        satisfactionDto.setSatisfactionWithGroupLeader(satisfaction.getSatisfactionWithGroupLeader());
        satisfactionDto.setSatisfactionWithTeamBuilding(satisfaction.getSatisfactionWithTeamBuilding());
        satisfactionDto.setSatisfactionWithCareerPath(satisfaction.getSatisfactionWithCareerPath());
        satisfactionDto.setDidTheCompagnySatisfyYourAmbitions(satisfaction.getDidTheCompagnySatisfyYourAmbitions());

        return satisfactionDto;
    }

    public static Satisfaction toSatisfaction(SatisfactionDto satisfactionDto) {
        var satisfaction = new Satisfaction();
        satisfaction.setTeamAtmosphere(satisfactionDto.getTeamAtmosphere());
        satisfaction.setWorkload(satisfactionDto.getWorkload());
        satisfaction.setCompagnySatisfactionScale(satisfactionDto.getCompagnySatisfactionScale());
        satisfaction.setSatisfactionWithTechnicalLeader(satisfactionDto.getSatisfactionWithTechnicalLeader());
        satisfaction.setSatisfactionWithTeamLeader(satisfactionDto.getSatisfactionWithTeamLeader());
        satisfaction.setSatisfactionWithProject(satisfactionDto.getSatisfactionWithProject());
        satisfaction.setSatisfactionWithGroupLeader(satisfactionDto.getSatisfactionWithGroupLeader());
        satisfaction.setSatisfactionWithTeamBuilding(satisfactionDto.getSatisfactionWithTeamBuilding());
        satisfaction.setSatisfactionWithCareerPath(satisfactionDto.getSatisfactionWithCareerPath());
        satisfaction.setDidTheCompagnySatisfyYourAmbitions(satisfactionDto.getDidTheCompagnySatisfyYourAmbitions());

        return satisfaction;
    }
}
