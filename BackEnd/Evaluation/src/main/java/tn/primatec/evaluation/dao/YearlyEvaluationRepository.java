package tn.primatec.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.primatec.evaluation.dto.EmployeeDto;

@RepositoryRestResource
public interface YearlyEvaluationRepository extends JpaRepository<EmployeeDto, Long> {
}
