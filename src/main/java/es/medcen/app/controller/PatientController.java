package es.medcen.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.medcen.app.model.Patient;
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
	/*
	@PutMapping("/tutorials/{id}")
	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
	    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      Tutorial _tutorial = tutorialData.get();
	      _tutorial.setTitle(tutorial.getTitle());
	      _tutorial.setDescription(tutorial.getDescription());
	      _tutorial.setPublished(tutorial.isPublished());
	      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	*/
	/*
	@RequestMapping(value = "usuarios/actualizar/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<UsuarioResponse> updateUser(@PathVariable("id") int userId,@RequestBody UsuarioSimple simple, @RequestHeader Map<String,String> headers) {
		logger.info("Update user");
		String userEmail = headers.getOrDefault(PARAM_USER_EMAIL,null);
		String userPwd = headers.getOrDefault(PARAM_USER_PWD,null);
		String newUserPwd = headers.getOrDefault(PARAM_USER_NEW_PWD,null);
		
		if (userEmail != null && userPwd != null && newUserPwd!=null) {
			// If userEmail and password are in the request
			if(validateUser(userEmail, userPwd)) {
				// Email and pwd are valid, check if user id is the same as Path variable
				Usuario usuario = repository.findUsuarioByCorreo(userEmail);
				if (usuario.getId() == userId) {
					UserLogin userLogin = userLoginUpdated(usuario.getId());
					if (userLogin.getUsuario().equals(usuario)) {
						// Update user info
						logger.info("Actualizando Datos");
						usuario.setBirthDate(simple.getBirthDate());
						usuario.setEmail(simple.getEmail());
						usuario.setName(simple.getName());
						usuario.setPhoneNumber(simple.getPhoneNumber());
						utilUsuarioLogin.updateCredentials(userId, newUserPwd);
						repository.save(usuario);
						UsuarioResponse response = UsuarioResponse.convert(usuario);
						return new ResponseEntity(response, HttpStatus.OK);
					}
				}
			}
		}
		return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
	}
	
	*/
}
