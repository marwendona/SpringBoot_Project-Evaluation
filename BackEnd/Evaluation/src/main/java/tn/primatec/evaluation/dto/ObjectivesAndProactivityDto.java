package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "objectives_and_proactivity")
@Data
public class ObjectivesAndProactivityDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastYearObjectives ")
    private String lastYearObjectives;

    @Column(name = "achievementsForLastYear")
    private String achievementsForLastYear;

    @Column(name = "targetsForNextYear ")
    private String targetsForNextYear;

    @Column(name = "keysAndToolsForTargetsSuccess")
    private String keysAndToolsForTargetsSuccess;

    @Column(name = "didYouEverRaise_HighlightAProblem ")
    private String didYouEverRaise_HighlightAProblem;

    @Column(name = "doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask")
    private String doYouFeelYourSelfAbleToSupportInDifferentTopicsThanYourMainTask;
}
