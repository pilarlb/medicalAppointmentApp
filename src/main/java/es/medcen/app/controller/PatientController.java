package es.medcen.app.controller;

import java.util.ArrayList;
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
import es.medcen.app.model.Patient;
import es.medcen.app.model.Slot;
import es.medcen.app.service.PatientService;
@RestController
@RequestMapping("/medcen")
public class PatientController {
	
	@Autowired
	private PatientService patientSer;
	
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
		
		ResponseEntity<Patient> _patient = patientSer.updatePatient(id, patient);
		
		return _patient;
		
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
		
		ResponseEntity<Appointment> response = patientSer.saveAppointment(appointment);
		/* para cambiar el estado Available del slot
		Slot slot = appointment.getSlot();
		slot.setAvailable(false);
		Long id = slot.getId();
		patientSer.updateSlot(id, slot);
		*/
		return response;
		
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
		
	
	
}
