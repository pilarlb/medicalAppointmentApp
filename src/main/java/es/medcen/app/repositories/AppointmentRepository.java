package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findByHealthWorker(HealthWorker healthworker);
	List<Appointment> findByPatient(Patient patient);
	
}
