package es.medcen.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient  extends Individual implements Serializable {
	
	/*
	 * oneToMany bidireccional: metodos a implementar
	 * - En el padre (one) addComment y removeComment
	 * - en el hijo (many) equals y hashCode
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5900846760787103371L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "has_insurance")
	private boolean hasInsurance;
	
	@Column(name = "insurance_company")
	private String insuranceCompany;
	
	//relacion unidireccional REVISAR orphanRemoval
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="appointments")
	private List<Appointment> appointments = new ArrayList<>();

	
	//CONSTRUCTORS 
	public Patient() {
		super();
	}

	public Patient(boolean hasInsurance, String insuranceCompany, List<Appointment> appointments) {
		super();
		this.hasInsurance = hasInsurance;
		this.insuranceCompany = insuranceCompany;
		this.appointments = appointments;
	}
	
	public Patient(String idCard, String name, String surname, Date birthDate, String phoneNumber, String address,
			String postalCode, String email, boolean hasInsurance, String insuranceCompany, List<Appointment> appointments) {
		super(idCard, name, surname, birthDate, phoneNumber, address, postalCode, email);
		this.hasInsurance = hasInsurance;
		this.insuranceCompany = insuranceCompany;
		this.appointments = appointments;
	}
	
	/*
	 * METHODS FOR ADDING AND REMOVING APPOINTMENTS
	 */
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		appointment.setPatient(this);
	}
	
	public void removeAppointment(Appointment appointment) {
		appointments.remove(appointment);
		appointment.setPatient(null);
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public boolean isHasInsurance() {
		return hasInsurance;
	}

	public void setHasInsurance(boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
}
