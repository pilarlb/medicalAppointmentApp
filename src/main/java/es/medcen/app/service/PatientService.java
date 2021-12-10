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
	//health SPECIALTY
	
	
	
	//PATIENT
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
		if(patient.getHasInsurance() == false) {
			patient.setInsuranceCompany(null);
		}
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
	public Patient updatePatient(Long id, Patient patient) {
		
		Optional<Patient> patientUp =patientRepo.findById(id);
			if(patientUp.isPresent()) {
				Patient patientUpdated = patientUp.get();
				if(patient.getIdCard() != null) {
					patientUpdated.setIdCard(patient.getIdCard());
				}
				if(patient.getAddress() != null) {
					patientUpdated.setAddress(patient.getAddress());
				}
				if(patient.getBirthDate() != null) {
					patientUpdated.setBirthDate(patient.getBirthDate());
				}
				if(patient.getEmail() != null) {
					patientUpdated.setEmail(patient.getEmail());
				}
				if(patient.getName() != null) {
					patientUpdated.setName(patient.getName());
				}
				if(patient.getSurname() != null) {
					patientUpdated.setSurname(patient.getSurname());
				}
				if(patient.getPhoneNumber() != null) {
					patientUpdated.setPhoneNumber(patient.getPhoneNumber());
				}
				if(patient.getPostalCode() != null) {
					patientUpdated.setPostalCode(patient.getPostalCode());
				}
				if(patient.getHasInsurance() != null) {
					patientUpdated.setHasInsurance(patient.getHasInsurance());
				}
				
				if(patient.getInsuranceCompany() != null) {
					patientUpdated.setInsuranceCompany(patient.getInsuranceCompany());
				}
				

				
				return patientRepo.save(patientUpdated);
			}else {
				return null;
			}
		}
		
/*
 * APPOINTMENTS------------------------------------- faltaria update
 */
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		
		Appointment _appo = appoRepo.save(appointment);
		
		return _appo;
		
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
	
	@Override
	public HealthWorker getHealthWorker(Long id) {
		Optional<HealthWorker> healthworker = healthWRepo.findById(id);
		 if(healthworker.isPresent()) {
			 return healthworker.get();
		 }else {
			 return null; 
		 }
		
	}
	
	
	/*
	 * schedule: READ no create, delete or update
	 * 
	 */
	
	@Override
	public Schedule getScheduleByHealthworkerAndByDate(Long idHealthworker, Calendar date) {
		//yyyy-mm-dd
		Optional<HealthWorker> _healthworker = healthWRepo.findById(idHealthworker);
		if(_healthworker.isPresent()) {
			HealthWorker healthworker = _healthworker.get();
			Schedule schedule = scheduleRepo.findByHealthWorkerAndDate(healthworker, date);
			return schedule;
		}else {
			return null;
		}
		
	}
	
	@Override
	public Schedule getScheduleByAppointment(Long idAppointment) {
		Optional<Appointment> appo = appoRepo.findById(idAppointment);
		Schedule sche;
		if(appo.isPresent()) {
			sche = appo.get().getSlot().getSchedule();
			
			if(sche.getFormattedDate() == null) {
				Calendar _dat = sche.getDate();
				int day= _dat.get(Calendar.DATE);
				int month = _dat.get(Calendar.MONTH);
				int year =_dat.get(Calendar.YEAR);
				String _day;
				String _month;
				if(day <10) {
					_day = "0"+String.valueOf(day);
				
				}else {
					_day=String.valueOf(day);
				}
				if(month<10) {
					_month= "0"+String.valueOf(month);
				}else {
					_month=String.valueOf(month);
				}
				String _year = String.valueOf(year);
				
				String completedDate = _day+"-"+_month+"-"+_year;
				sche.setFormattedDate(completedDate);
				Schedule scheDate = new Schedule();
				scheDate.setFormattedDate(completedDate);
				updateSchedule(sche.getId(),scheDate);
				
			}
			
			System.out.println("BUCLE - IDAPPOINTMENT -----SCHEDULE LIST");
			return sche;
		}
		return null;
	}
	
	@Override
	public List<Schedule> getSchedulesByHealthWorkerAndByIsWorkingDay (Long idHealthworker, boolean IsWorkingDay){
		List<Schedule>  scheduleList = new ArrayList<>();
		Optional<HealthWorker> _healthworker = healthWRepo.findById(idHealthworker);
		if(_healthworker.isPresent()) {
			HealthWorker healthworker = _healthworker.get();
			scheduleList = scheduleRepo.findByHealthWorkerAndIsWorkingDay(healthworker, IsWorkingDay);
			
			for (Schedule schedule: scheduleList) {
				if(schedule.getFormattedDate() == null) {
					Calendar _dat = schedule.getDate();
					int day= _dat.get(Calendar.DATE);
					int month = _dat.get(Calendar.MONTH);
					int year =_dat.get(Calendar.YEAR);
					String _day;
					String _month;
					if(day <10) {
						_day = "0"+String.valueOf(day);
					
					}else {
						_day=String.valueOf(day);
					}
					if(month<10) {
						_month= "0"+String.valueOf(month);
					}else {
						_month=String.valueOf(month);
					}
					String _year = String.valueOf(year);
					
					String completedDate = _day+"-"+_month+"-"+_year;
					schedule.setFormattedDate(completedDate);
					Schedule scheDate = new Schedule();
					scheDate.setFormattedDate(completedDate);
					
					updateSchedule(schedule.getId(),scheDate);
					
				}
				System.out.println("BUCLE - IDHEALTHWORKER AND BOOLEAN DAY -----SCHEDULE LIST");
			}
			
		}//.ispresent
		if(scheduleList.size() != 0) {
			return scheduleList;
		}else {
			return null;
		}
	}
	
	@Override
	public Schedule updateSchedule(Long idSchedule, Schedule sche) {
		Optional<Schedule> _sche = scheduleRepo.findById(idSchedule);
		
		if(_sche.isPresent()) {
			Schedule schedule = _sche.get();
			if(sche.getFormattedDate() != null) {
				schedule.setFormattedDate(sche.getFormattedDate());
			}
			//quite el Slots
			if(sche.getDate() != null) {
				schedule.setDate(sche.getDate());
			}
			if(sche.getHealthWorker() != null) {
				schedule.setHealthWorker(sche.getHealthWorker());
			}
			
			 scheduleRepo.save(schedule);
			 return schedule;
		}else {
			return null;
		}
		
	}
	
	/*
	 * SLOTS DE UN SCHEDULE con workingday
	 * Read and Update Slot no create ni delete
	 */
		//READ SLOT
		@Override
		public List<Slot> getSlotsBySchedule(Long iDschedule){
			List<Slot> slotList = new ArrayList<Slot>();
			Optional<Schedule> _schedule = scheduleRepo.findById(iDschedule);
			if(_schedule.isPresent()) {
				Schedule schedule = _schedule.get();
				 slotList = slotRepo.findBySchedule(schedule);
			}
			if(slotList.size() != 0) {
				return slotList;
			}else {
				return null;
			}
			
		}
		@Override
		public List<Slot> getSlotsByScheduleAndAvailable(Long iDschedule,boolean available, String hourTime){
			List<Slot> slotList  = new ArrayList<Slot>();
			List<Slot> slotHourList  = new ArrayList<Slot>();
			
		
			
			Optional<Schedule> _schedule = scheduleRepo.findById(iDschedule);
			if(_schedule.isPresent()) {
				Schedule schedule = _schedule.get();
				 slotList = slotRepo.findByScheduleAndAvailable(schedule, available);
			}
			if(slotList.size() != 0) {
				
				for (Slot slot: slotList){
					
					if(slot.getAppointmentTime().startsWith(hourTime)) {
						slotHourList.add(slot); 
					}
				}
				
				if(slotHourList.size() != 0) {
					return slotHourList;
				}else {
					return slotList;
				}
				
				
			}else {
				return null;
			}
		}
		
		@Override
		public Slot getSlot(Long id) {
			Optional<Slot> slot = slotRepo.findById(id);
			if(slot.isPresent()) {
				return slot.get();
			}else {
				return null;
			}
		}
	//UPDATE SLOT
		@Override 
		public Slot updateSlot(Long id, Slot slot){
			Optional<Slot> slotR = slotRepo.findById(id);
			if(slotR.isPresent()) {
				Slot _slot = slotR.get();
				if(slot.getAppointment() != null) {
					_slot.setAppointment(slot.getAppointment());
				}
				if(slot.getAppointmentTime() != null) {
					_slot.setAppointmentTime(slot.getAppointmentTime());
				}
				if(slot.getSchedule() != null) {
					_slot.setSchedule(slot.getSchedule());
				}
				if(slot.isAvailable() != null) {
					_slot.setAvailable(slot.isAvailable());
				}
				
				return slotRepo.save(_slot);
			}else {
				return null;
			}
	
		}
	

	
}
