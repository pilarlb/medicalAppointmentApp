package es.medcen.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.medcen.app.model.Appointment;
import es.medcen.app.model.HealthWorker;
import es.medcen.app.model.Patient;
import es.medcen.app.model.Schedule;
import es.medcen.app.model.Slot;
import es.medcen.app.repositories.SlotRepository;
import es.medcen.app.service.PatientService;
@RestController
@RequestMapping("/medcen")
public class PatientController {
	
	@Autowired
	private PatientService patientSer;
	
	/*
	 * Patients
	 */
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	       int number = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getPatients(@RequestParam(required = false) String surname,
			@RequestParam(required = false) Long id){
		List<Patient> patientList = new ArrayList<>();
		
		if(surname == null && id == null) {
			patientList = patientSer.getPatients();
		}else if (id == null){
			patientList = patientSer.getPatientsBySurname(surname);
		}else {
			patientList.add(patientSer.getPatientById(id));
		}
		
		if(patientList.size() != 0) {
			return new ResponseEntity<>(patientList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	//CREATE PATIENT
	
	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
	    try {
	    Patient pat = patientSer.savePatient(patient);
	    
	      return new ResponseEntity<>(pat, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	//UPDATE PATIENT
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
		
		Patient _patient = patientSer.updatePatient(id, patient);
		
		if(_patient != null) {
			 return new ResponseEntity<>(_patient, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//DELETE PATIENT
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") Long id) {
		
		try {
		      patientSer.deletePatient(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	/*
	 * APPOINTMENTS
	 */
	//READ
	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getAppointment(@RequestParam(required = false) Long id,
			@RequestParam(required = false) Long idPatient, @RequestParam(required = false) Long idDoctor ){
			
		List<Appointment> appoList = new ArrayList<>();
		
		if(idPatient == null && idDoctor == null) {
			Appointment _appoint = patientSer.getAppointment(id);
			appoList.add(_appoint);
			
		}else if (id==null && idDoctor == null){
			appoList = patientSer.getAppointmentsPatient(idPatient);
		}else {
			appoList = patientSer.getAppointmentsDoc(idDoctor);
		}
		
		if(appoList.size() != 0) {
			return new ResponseEntity<>(appoList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	//CREATE
	@RequestMapping(value = "/appointments", method = RequestMethod.POST)
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){
		
		if(appointment.getPatient() == null) {

			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}else {
			
			Slot slot = appointment.getSlot();
			if(appointment.getHealthWorker()  == null) {
				HealthWorker healthworker = slot.getSchedule().getHealthWorker();
				appointment.setHealthWorker(healthworker);
			}
			
			ResponseEntity<Appointment> response = patientSer.saveAppointment(appointment);
			
			// para cambiar el estado Available del slot
			
			Long id = slot.getId();
			Slot _slot = new Slot();
			_slot.setAvailable(false);
			patientSer.updateSlot(id, _slot);
			
			return response;
		}
		
		
	}
	
	
	//DELETE
	@RequestMapping(value = "/appointments/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteAppointment(@PathVariable("id") Long id) {
		
		try {
		      patientSer.deleteAppointment(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
		
	
	//DOCTOR 
	//READ
	@RequestMapping(value = "/healthworkers", method = RequestMethod.GET)
	public ResponseEntity<List<HealthWorker>> getHealthworker(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String specialty, @RequestParam(required = false) String surname ){
				
		 List<HealthWorker> healthworkerList= new ArrayList<>();
		 
		 if(id != null) {
			 HealthWorker _healthworker = patientSer.getHealthWorker(id);
			 healthworkerList.add(_healthworker);
			 
		 }else if (specialty != null) {
			 healthworkerList = patientSer.getDocBySpecialty(specialty); // containing
			 
		 }else if (surname != null) {
			 healthworkerList = patientSer.getHealthWorkerBySurname(surname);
			 
		 }else {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		
		 return new ResponseEntity<>(healthworkerList, HttpStatus.OK);
		
	}
	
	//SCHEDULE
	//read
	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public ResponseEntity<List<Schedule>> getSchedule(@RequestBody HealthWorker healthworker,
			@RequestParam(required = false) boolean IsWorkingDay, @RequestParam(required = false) String date){
		
		List<Schedule> scheList = new ArrayList<>();
		if(date != null) { //date format dd-mm-yyyy
			
			SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
				
				String[] parts = date.split("-");
				if(parts.length == 3) {
					String day = parts[0];
					String month= parts[1];
					String year = parts[2];
					
					if(isNumeric(day) && isNumeric(month) && isNumeric(year) &&
					day.length() == 2 && month.length() == 2 && year.length()== 4) {				
						try {
						
							Date calDate = formatdate.parse(year+"-"+month+"-"+day);
							Calendar cal = new GregorianCalendar();
							cal.setTime(calDate);
							
							Schedule schedule = patientSer.getScheduleByHealthworkerAndByDate(healthworker, cal);
							scheList.add(schedule);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
				
		}else  {
			scheList = patientSer.getSchedulesByHealthWorkerAndByIsWorkingDay(healthworker, IsWorkingDay);
		}
		
		if(scheList.size() != 0) {
			return new ResponseEntity<>(scheList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	//SLOT
	//read
	@RequestMapping(value = "/slots", method = RequestMethod.GET)
	public ResponseEntity<List<Slot>> getSlots(@RequestBody Schedule schedule,
			@RequestParam(required = false) Boolean available){
		List<Slot> slotList =  new ArrayList<>();
		if(available != null) {
			slotList = patientSer.getSlotsByScheduleAndAvailable(schedule, available);
		}else {
			slotList = patientSer.getSlotsBySchedule(schedule);
		}
		return new ResponseEntity<>(slotList, HttpStatus.OK);
		
		
	}
	@RequestMapping(value = "/slots/{id}", method = RequestMethod.GET)
	public ResponseEntity<Slot> getSlot(@PathVariable("id") Long id){
				
		Slot slot = patientSer.getSlot(id);
		if(slot != null) {
			return new ResponseEntity<>(slot, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	//Update
	@RequestMapping(value = "/slots", method = RequestMethod.PUT)
	public ResponseEntity<Slot> updateSlot(@RequestParam(required = true) Long id, @RequestBody Slot slot) {
		
		Slot _slot= patientSer.updateSlot(id, slot);
		
		if(_slot != null) {
			
				 return new ResponseEntity<>(_slot, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	}
		
	
	
}
