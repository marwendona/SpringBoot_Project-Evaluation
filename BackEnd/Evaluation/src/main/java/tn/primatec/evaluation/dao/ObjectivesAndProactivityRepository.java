package tn.primatec.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.primatec.evaluation.dto.ObjectivesAndProactivityDto;

@RepositoryRestResource
public interface ObjectivesAndProactivityRepository extends JpaRepository<ObjectivesAndProactivityDto, Long> {
}
