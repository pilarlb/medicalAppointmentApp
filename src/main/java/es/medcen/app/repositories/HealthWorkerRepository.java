package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthWorkerRepository extends JpaRepository<HealthWorker, Long> {

	List<HealthWorker> findBySurnameContaining (String surname);
	List<HealthWorker> findByIdCardContaining (String idcard);
	//List<HealthWorker> findByHealthSpecialtyContaining(String healthspecialty);
}
