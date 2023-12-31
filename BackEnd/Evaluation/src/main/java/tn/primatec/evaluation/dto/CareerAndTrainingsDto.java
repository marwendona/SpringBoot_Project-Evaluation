package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "career_and_trainings")
@Data
public class CareerAndTrainingsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "whichPathYouSeeItSuitableForYou")
    private String whichPathYouSeeItSuitableForYou;

    @Column(name = "doYouHaveTargetRoleOrPosition")
    private String doYouHaveTargetRoleOrPosition;

    @Column(name = "requestForTraining")
    private String inOrderToReachYourObjective_RoleWhatDoYouRequestForTraining;

    @OneToOne(mappedBy = "careerAndTrainings")
    private EmployeeDto employee;
}
