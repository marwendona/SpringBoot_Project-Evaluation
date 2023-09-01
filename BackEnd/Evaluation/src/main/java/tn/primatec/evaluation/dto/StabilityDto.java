package tn.primatec.evaluation.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stability")
@Data
public class StabilityDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "areYouActivelyLookingForJobOffers")
    private String areYouActivelyLookingForJobOffers;

    @Column(name = "areYouOpenToTechnica_sOffers")
    private String areYouOpenToTechnica_sOffers;

    @OneToOne(mappedBy = "stability")
    private EmployeeDto employee;
}
