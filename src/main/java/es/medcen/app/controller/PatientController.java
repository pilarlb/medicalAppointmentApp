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
	 * METHODS
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
	//method for formatted Date
	public List<Schedule> datetoString (List<Schedule> list){
		for (Schedule schedule: list) {
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
				patientSer.updateSchedule(schedule.getId(),scheDate);
				
			}
			
		}
		return list;
	}
	
	public Calendar dateToCalendar(String date) {
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar();
		String[] parts = date.split("-");
		if(parts.length == 3) {
			String day = parts[0];
			String month= parts[1];
			String year = parts[2];
			
			if(isNumeric(day) && isNumeric(month) && isNumeric(year) &&
			day.length() == 2 && month.length() == 2 && year.length()== 4) {				
				
				
					Date calDate = null;
					try {
						calDate = formatdate.parse(year+"-"+month+"-"+day);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					cal.setTime(calDate);
					
			}
			}
		return cal;
	}
	
	
	
	/*
	 * Patients
	 */
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
	public Appointment saveAppointment(@RequestBody Appointment appointment){
		
		if(appointment.getPatient() == null) {
			
			return null;
			//return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}else {
			
			Slot slot = appointment.getSlot();
			if(appointment.getHealthWorker()  == null) {
				HealthWorker healthworker = slot.getSchedule().getHealthWorker();
				appointment.setHealthWorker(healthworker);
			}
			
			Appointment appo = patientSer.saveAppointment(appointment);
			
			// para cambiar el estado Available del slot
			
			Long id = slot.getId();
			Slot _slot = new Slot();
			_slot.setAvailable(false);
			patientSer.updateSlot(id, _slot);
			
			return appo;
			//return new ResponseEntity<>(appo,HttpStatus.CREATED);
		}
		
		
	}
	
	
	//DELETE
	@RequestMapping(value = "/appointments/{id}", method = RequestMethod.DELETE)
	public List<String> deleteAppointment(@PathVariable("id") Long id) {
		
		try {
				Slot slot = patientSer.getAppointment(id).getSlot();
				slot.setAvailable(true);
				patientSer.updateSlot(slot.getId(), slot);
		      patientSer.deleteAppointment(id);
		      List<String> array = new ArrayList<String>();
		      array.add("HttpStatus.OK");
		      return array ;
		    } catch (Exception e) {
		      return null ;
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
	public ResponseEntity<List<Schedule>> getSchedule(@RequestParam (required = false) Long iDhealthworker,
			@RequestParam(required = false) boolean IsWorkingDay, @RequestParam(required = false) String date,
			@RequestParam(required = false) Long idAppointment){
		
		List<Schedule> scheList = new ArrayList<>();
		
		if (idAppointment != null){
			Schedule sche = patientSer.getScheduleByAppointment(idAppointment);
			if(sche != null) {
				scheList.add(sche);
				//scheList = datetoString(scheList);
			}
		}else if(iDhealthworker != null && date != null ) {//date format dd-mm-yyyy
			Calendar cal = dateToCalendar(date);
			Schedule schedule = patientSer.getScheduleByHealthworkerAndByDate(iDhealthworker, cal);
			scheList.add(schedule);
			scheList = datetoString(scheList);
		}else if(iDhealthworker != null) {
			scheList = patientSer.getSchedulesByHealthWorkerAndByIsWorkingDay(iDhealthworker, IsWorkingDay);
			
				
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
	public ResponseEntity<List<Slot>> getSlots(@RequestParam Long iDschedule,
			@RequestParam Boolean available,
			@RequestParam String hourTime){
		List<Slot> slotList =  new ArrayList<>();
		//Schedule schedule = patientSer
		if(available != null) {
			slotList = patientSer.getSlotsByScheduleAndAvailable(iDschedule, available, hourTime);
		}else {
			slotList = patientSer.getSlotsBySchedule(iDschedule);
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
