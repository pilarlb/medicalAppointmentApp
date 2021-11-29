package es.medcen.app.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.http.ResponseEntity;

import es.medcen.app.model.*;
public interface IPatientService {
	
	List<Patient> getPatientsBySurname(String surname);
	Patient getPatientsByIdcard(String idcard);
	Patient getPatientById(Long id);
	Patient savePatient(Patient patient);
	ResponseEntity<Patient> updatePatient(Long id, Patient patient);
	void deletePatient (Long id);
	void deletePatient (Patient patient);
	List<Patient> getPatients();
	List<Appointment> getAppointmentsPatient(Long id);
	List<Appointment> getAppointmentsDoc(Long id);
	ResponseEntity<Appointment> saveAppointment(Appointment appointment, Patient patient, Slot slot);
	void deleteAppointment(Long id);
	List<HealthWorker> getDocBySpecialty(String specialty);
	List<HealthWorker> getHealthWorkerBySurname(String surname);
	List<HealthWorker> getHealthWorkerByIdcard(String idcard);
	Schedule getScheduleByHealthworkerAndByDate(HealthWorker healthworker, Calendar date);
	List<Schedule> getSchedulesByHealthWorkerAndByIsWorkingDay(HealthWorker healthworker, boolean IsWorkingDay);
	
}

