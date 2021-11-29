package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthSpecialtyRepository extends JpaRepository<HealthSpecialty, Long> {

	List<HealthSpecialty> findBySpecialtyContaining (String specialty);
	List<HealthSpecialty> findByHealthworker(HealthWorker healthworker);
}
