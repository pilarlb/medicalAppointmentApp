package es.medcen.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.medcen.app.model.Patient;
import es.medcen.app.repositories.PatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public List<Patient> getPatientsByApellidos(String apellido) {
		
		List<Patient> lista = patientRepo.findBySurnameContaining(apellido);
		
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
	public boolean savePatient(Patient patient) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return null;
	}

}
