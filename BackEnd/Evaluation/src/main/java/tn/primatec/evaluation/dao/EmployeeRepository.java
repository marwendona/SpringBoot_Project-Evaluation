package tn.primatec.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.primatec.evaluation.dto.EmployeeDto;

import java.util.Optional;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {
    Optional<EmployeeDto> findById(Long id);
}
