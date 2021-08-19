package es.medcen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="slots")
public class Slot implements Serializable{
	
	/**
	 * Lista de slots/horas disponibles
	 * -ID
	 * -TIME
	 * -AVAILABLE
	 * ID_DAY_SCHEDULE
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Ojo he puesto strings, podrian ser int
	@Column(name = "appointment_time",nullable = false)
	private String appointmentTime;
	
	private boolean available;
	
	
	//lado de NO foreign key
	@OneToOne(mappedBy="slot")
	private Appointment appointment;
	
	//bidirectional horario
	@ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

	
	
	//CONSTRUCTORS
	public Slot() {
		super();
	}
	public Slot(String appointmentTime, boolean available, Appointment appointment, Schedule schedule) {
		super();
		this.appointmentTime = appointmentTime;
		this.available = available;
		this.appointment = appointment;
		this.schedule = schedule;
	}
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
	
	
}
