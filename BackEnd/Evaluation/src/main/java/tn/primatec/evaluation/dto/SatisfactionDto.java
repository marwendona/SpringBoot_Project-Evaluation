package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "satisfaction")
@Data
public class SatisfactionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teamAtmosphere")
    private int teamAtmosphere;

    @Column(name = "team")
    private String team;

    @Column(name = "workload")
    private int workload;

    @Column(name = "compagnySatisfactionScale")
    private int compagnySatisfactionScale;

    @Column(name = "satisfactionWithTechnicalLeader")
    private int satisfactionWithTechnicalLeader;

    @Column(name = "satisfactionWithTeamLeader")
    private int satisfactionWithTeamLeader;

    @Column(name = "satisfactionWithProject")
    private int satisfactionWithProject;

    @Column(name = "satisfactionWithGroupLeader")
    private int satisfactionWithGroupLeader;

    @Column(name = "satisfactionWithTeamBuilding")
    private int satisfactionWithTeamBuilding;

    @Column(name = "satisfactionWithCareerPath")
    private int satisfactionWithCareerPath;

    @Column(name = "didTheCompagnySatisfyYourAmbitions")
    private int didTheCompagnySatisfyYourAmbitions;

    @Column(name = "totalScore")
    private float totalScore;

    @OneToOne(mappedBy = "satisfaction")
    private EmployeeDto employee;
}
