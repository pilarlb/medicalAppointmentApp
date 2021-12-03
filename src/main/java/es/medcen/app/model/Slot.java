package es.medcen.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="slots")
public class Slot implements Serializable{
	
	private static final long serialVersionUID = 3397184904070958210L;

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
	
	
	@Column(name = "appointment_time",nullable = false)
	@Enumerated(EnumType.STRING)
	private AppointmentTime appointmentTime;
	
	private boolean available;
	
	
	//lado de NO foreign key
	@JsonIgnore
	@OneToOne(mappedBy="slot")
	private Appointment appointment;
	
	//bidirectional horario
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

	
	
	//CONSTRUCTORS
	public Slot() {
		super();
	}
	public Slot(AppointmentTime appointmentTime, boolean available, Appointment appointment, Schedule schedule) {
		super();
		this.appointmentTime = appointmentTime;
		this.available = available;
		this.appointment = appointment;
		this.schedule = schedule;
	}
	
	@Override
	public String toString() {
		return "Slot [id=" + id + ", appointmentTime=" + appointmentTime + ", available=" + available + ", appointment="
				+ appointment + ", schedule=" + schedule + "]";
	}
		//EQUALS AND HASHCODE
		@Override
		public int hashCode() {
			return getClass().hashCode();	
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Slot )) return false;
	        return id != null && id.equals(((Slot) o).getId());
	    }
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	

	public AppointmentTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(AppointmentTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public Boolean isAvailable() {
		return Boolean.parseBoolean(String.valueOf(available));
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
