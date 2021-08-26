package es.medcen.app.repositories;

import es.medcen.app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
