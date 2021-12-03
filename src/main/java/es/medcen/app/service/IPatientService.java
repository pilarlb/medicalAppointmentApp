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
	Patient updatePatient(Long id, Patient patient);
	void deletePatient (Long id);
	List<Patient> getPatients();
	Appointment getAppointment(Long id);
	List<Appointment> getAppointmentsPatient(Long id);
	List<Appointment> getAppointmentsDoc(Long id);
	ResponseEntity<Appointment> saveAppointment(Appointment appointment);
	void deleteAppointment(Long id);
	List<HealthWorker> getDocBySpecialty(String specialty);
	List<HealthWorker> getHealthWorkerBySurname(String surname);
	List<HealthWorker> getHealthWorkerByIdcard(String idcard);
	Schedule getScheduleByHealthworkerAndByDate(HealthWorker healthworker, Calendar date);
	List<Schedule> getSchedulesByHealthWorkerAndByIsWorkingDay(HealthWorker healthworker, boolean IsWorkingDay);
	Slot updateSlot(Long id, Slot slot);
	HealthWorker getHealthWorker(Long id);
	List<Slot> getSlotsBySchedule(Schedule schedule);
	List<Slot> getSlotsByScheduleAndAvailable(Schedule schedule, boolean available);
	Slot getSlot(Long id);
	
	
	
}

