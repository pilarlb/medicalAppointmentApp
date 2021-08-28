package es.medcen.app.repositories;

import es.medcen.app.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findBySurnameContaining (String surname);
}
