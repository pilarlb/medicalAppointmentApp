package es.medcen.app.service;

import java.util.List;

import es.medcen.app.model.*;
public interface IPatientService {
	
	List<Patient> getPatientsByApellidos(String apellido);
	Patient getPatientById(Long id);
	boolean savePatient(Patient patient);
	boolean updatePatient(Patient patient);
	boolean deletePatient (Long id);
	boolean deletePatient (Patient patient);
	List<Patient> getPatients();
	
	
}
