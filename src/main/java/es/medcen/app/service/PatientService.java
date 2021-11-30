package es.medcen.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.medcen.app.model.Appointment;
import es.medcen.app.model.HealthSpecialty;
import es.medcen.app.model.HealthWorker;
import es.medcen.app.model.Patient;
import es.medcen.app.model.Schedule;
import es.medcen.app.model.Slot;
import es.medcen.app.repositories.AppointmentRepository;
import es.medcen.app.repositories.HealthSpecialtyRepository;
import es.medcen.app.repositories.HealthWorkerRepository;
import es.medcen.app.repositories.PatientRepository;
import es.medcen.app.repositories.ScheduleRepository;
import es.medcen.app.repositories.SlotRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private AppointmentRepository appoRepo;
	@Autowired
	private HealthSpecialtyRepository specialtyRepo;
	@Autowired
	private HealthWorkerRepository healthWRepo;
	@Autowired 
	private ScheduleRepository scheduleRepo;
	@Autowired
	private SlotRepository slotRepo;
	
	@Override
	public Patient getPatientsByIdcard(String idcard) { //idcard
		Patient patient = patientRepo.findByIdCardContaining(idcard);
		if(patient != null) {
			return patient;
		}else {
			return null;
		}
	}

	@Override
	public List<Patient> getPatientsBySurname(String surname) {
		
		List<Patient> lista = patientRepo.findBySurnameContaining(surname);
		
			if(lista.size() == 0) {
				return null;
			}else {
				return lista;
			}
		}
		
	@Override
	public Patient getPatientById(Long id) {
		 Optional<Patient> patient = patientRepo.findById(id);
		 if(patient.isPresent()) {
			 return patient.get();
		 }else {
			 return null; 
		 }
		
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		Patient pat = patientRepo.save(patient);
		return pat;
		
	}
	
	@Override
	public List<Patient> getPatients() {
		
		List<Patient> patients = new ArrayList<Patient>();
		patientRepo.findAll().forEach(patients::add);
		
		return patients;
	}
	
	@Override
	public void deletePatient(Long id) {
		patientRepo.deleteById(id);
		
	}

	
	@Override
	public ResponseEntity<Patient> updatePatient(Long id, Patient patient) {
		
		Optional<Patient> patientUp =patientRepo.findById(id);
		if(patientUp.isPresent()) {
			Patient patientUpdated = patientUp.get();
			patientUpdated.setIdCard(patient.getIdCard());
			patientUpdated.setAddress(patient.getAddress());
			patientUpdated.setBirthDate(patient.getBirthDate());
			patientUpdated.setEmail(patient.getEmail());
			patientUpdated.setName(patient.getName());
			patientUpdated.setPhoneNumber(patient.getPhoneNumber());
			patientUpdated.setPostalCode(patient.getPostalCode());
			patientUpdated.setSurname(patient.getSurname());
			patientUpdated.setHasInsurance(patient.getHasInsurance());
			patientUpdated.setInsuranceCompany(patient.getInsuranceCompany());
			
			
			return new ResponseEntity<>(patientRepo.save(patientUpdated),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
		
/*
 * APPOINTMENTS------------------------------------- faltaria update
 */
	@Override
	public ResponseEntity<Appointment> saveAppointment(Appointment appointment) {
		
		Appointment _appo = appoRepo.save(appointment);
		
		return new ResponseEntity<>(_appo,HttpStatus.CREATED);
		
	}
	
		
	
	@Override
	public Appointment getAppointment(Long id) {
		
		Optional<Appointment> appoint = appoRepo.findById(id);
		 if(appoint.isPresent()) {
			 return appoint.get();
		 }else {
			 return null; 
		 }
		
	}
	
	@Override
	public List<Appointment> getAppointmentsPatient(Long id) {
		List<Appointment> appolist = new ArrayList<>();
		Optional<Patient> patient = patientRepo.findById(id);
		if(patient.isPresent()) {
			appolist = patient.get().getAppointments();
			return appolist;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<Appointment> getAppointmentsDoc(Long id) {
		List<Appointment> appolist = new ArrayList<>();
		Optional<HealthWorker> healthworker = healthWRepo.findById(id);
		if(healthworker.isPresent()) {
			appolist = healthworker.get().getAppointments();
			return appolist;
		}else {
			return null;
		}
	}

	@Override
	public void deleteAppointment(Long id) {
		appoRepo.deleteById(id);
	}

	
	
	
	/*
	 * Listar doctores por especialidad
	 * cada especialidad se repite por doctor que la tieneç
	 * 
	 */
	/*
	 * healthworkers-------------- READ no create, no delete or update
	 */
	@Override
	public List<HealthWorker> getDocBySpecialty(String specialty) {
		List<HealthWorker> docList = new ArrayList<>();
		List<HealthSpecialty> specialtyList = new ArrayList<>();
		specialtyList = specialtyRepo.findBySpecialtyContaining(specialty);
		
		if(specialtyList.size() != 0) {
			for (HealthSpecialty hs: specialtyList) {
				docList.add(hs.getHealthworker());
			}
			if(docList.size() != 0) {
				return docList;
			}else {
				return null;
			}
		}else {
			return null;
		}
		
		
	}
	
	@Override
	public List<HealthWorker> getHealthWorkerBySurname(String surname) {
		List<HealthWorker> hwList = healthWRepo.findBySurnameContaining(surname);
		if(hwList.size() != 0) {
			return hwList;
		}else {
			return null;
		}
	}

	@Override
	public List<HealthWorker> getHealthWorkerByIdcard(String idcard) {
		List<HealthWorker> hwList = healthWRepo.findByIdCardContaining(idcard);
		if(hwList.size() != 0) {
			return hwList;
		}else {
			return null;
		}
	}
	/*
	 * schedule: READ no create, delete or update
	 * 
	 */
	
	@Override
	public Schedule getScheduleByHealthworkerAndByDate(HealthWorker healthworker, Calendar date) {
		//yyyy-mm-dd
		Schedule schedule = scheduleRepo.findByHealthWorkerAndDate(healthworker, date);
		return schedule;
	}
	
	@Override
	public List<Schedule> getSchedulesByHealthWorkerAndByIsWorkingDay (HealthWorker healthworker, boolean IsWorkingDay){
		List<Schedule>  scheduleList = new ArrayList<>();
		scheduleList = scheduleRepo.findByHealthWorkerAndIsWorkingDay(healthworker, IsWorkingDay);
		if(scheduleList.size() != 0) {
			return scheduleList;
		}else {
			return null;
		}
		
	}
	
	/*
	 * SLOTS DE UN SCHEDULE con workingday
	 * Read and Update Slot no create ni delete
	 */

	//UPDATE SLOT
		@Override 
		public ResponseEntity<Slot> updateSlot(Long id, Slot slot){
			Optional<Slot> slotR = slotRepo.findById(id);
			if(slotR.isPresent()) {
				Slot _slot = slotR.get();
				_slot.setAppointment(slot.getAppointment());
				_slot.setAvailable(slot.isAvailable());
				_slot.setAppointmentTime(slot.getAppointmentTime());
				_slot.setSchedule(slot.getSchedule());
				
				return new ResponseEntity<>(slotRepo.save(_slot),HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	
		}
	

	
}
