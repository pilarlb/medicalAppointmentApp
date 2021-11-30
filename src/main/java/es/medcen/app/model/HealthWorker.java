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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="health_workers")
public class HealthWorker extends Individual implements Serializable {
	
	/**
	 * HealthWorker hereda de individual
	 */
	private static final long serialVersionUID = 6317182174856851446L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "practicing_from")
	private Date practicingFrom;
	
	@Column(name="procurement_date")
	private Date procurementDate;
	
	
	@Override
	public String toString() {
		return "HealthWorker [id=" + id + ", practicingFrom=" + practicingFrom + ", procurementDate=" + procurementDate
				+ ", healthSpecialties=" + healthSpecialties + ", schedules=" + schedules + ", appointments="
				+ appointments + "]";
	}

	/*
	 * oneToMany bidireccional: metodos a implementar
	 * - En el padre (one) addComment y removeComment
	 * - en el hijo (many) equals y hashCode
	 */
	//bidireccional ---ESPECIALIDADES
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="health_specialties")
	private List<HealthSpecialty> healthSpecialties  = new ArrayList<>();
	
	//bidireccional: muchos horarios diarios
	@JsonIgnore
	@OneToMany(mappedBy="healthWorker",cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="schedules")
	private List<Schedule> schedules = new ArrayList<>();
	
	//Bidirecciional:Un doctor, muchas citas
	@JsonIgnore
	@OneToMany(mappedBy="healthWorker",cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="appointments")
	private List<Appointment> appointments = new ArrayList<>();
	
	
	
	//CONSTRUCTORS
	public HealthWorker() {
		super();
	}

	public HealthWorker(String idCard, String name, String surname, Date birthDate, String phoneNumber, String address,
			String postalCode, String email,Date practicingFrom, Date procurementDate, List<HealthSpecialty> healthSpecialties,
			List<Schedule> schedules, List<Appointment> appointments) {
		super(idCard, name, surname, birthDate, phoneNumber, address, postalCode, email);
		this.practicingFrom = practicingFrom;
		this.procurementDate = procurementDate;
		this.healthSpecialties = healthSpecialties;
		this.schedules = schedules;
		this.appointments = appointments;
	}
	
	
	/*
	 * METHODS FOR ADDING AND REMOVING HEALTHSPECIALTIES
	 */

	public void addHealthSpecialty(HealthSpecialty healthspecialty){
		healthSpecialties.add(healthspecialty);
		healthspecialty.setHealthworker(this);
	                         
	}
	public void removeHealthSpecialty(HealthSpecialty healthspecialty){
		healthSpecialties.remove(healthspecialty);
		healthspecialty.setHealthworker(null);
	
	}
	
	/*
	 * METHODS FOR ADDING AND REMOVING SCHEDULES
	 */
	
	public void addSchedule(Schedule schedule) {
		schedules.add(schedule);
		schedule.setHealthWorker(this);
	}
	
	public void removeSchedule(Schedule schedule) {
		schedules.remove(schedule);
		schedule.setHealthWorker(null);
	}
	
	/*
	 * METHODS FOR ADDING AND REMOVING APPOINTMENTS
	 */
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
		appointment.setHealthWorker(this);
	}
	
	public void removeAppointment(Appointment appointment) {
		appointments.remove(appointment);
		appointment.setHealthWorker(null);
	}
	//GETTERS AND SETTERS---------------------------
	public Long getId() {
		return id;
	}

	public Date getPracticingFrom() {
		return practicingFrom;
	}

	public void setPracticingFrom(Date practicingFrom) {
		this.practicingFrom = practicingFrom;
	}

	public Date getProcurementDate() {
		return procurementDate;
	}

	public void setProcurementDate(Date procurementDate) {
		this.procurementDate = procurementDate;
	}

	public List<HealthSpecialty> getHealthSpecialties() {
		return healthSpecialties;
	}

	public void setHealthSpecialties(List<HealthSpecialty> healthSpecialties) {
		this.healthSpecialties = healthSpecialties;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
}
