package es.medcen.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="appointments")
public class Appointment implements Serializable{
	
 
	private static final long serialVersionUID = -2715960671928715496L;


	/**
	 * Citas: el horario de los medicos
	 * hay muchas citas asignadas a un dia de horario
	 * 
	 * -ID
	 * -STATUS
	 * -NOTES
	 * -id_doctor
	 * -id_patient
	 * -id_day_schedule --- quitado, duda
	 * -id_slot
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Estado de la cita: activa, completada, cancelada, noShow-noAparecio)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//Notas, observaciones sobre la cita
	private String notes;
	

	//Relacion uno a uno: una cita, un slot
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "slot")
	private Slot slot;
	
	//bidirectional 
	@ManyToOne(fetch = FetchType.LAZY)
    private HealthWorker healthWorker;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

	
	
	//CONSTRUCTORS
	public Appointment() {
		super();
	}
	
	public Appointment(Status status, String notes, Slot slot, HealthWorker healthWorker,
			Patient patient) {
		super();
		this.status = status;
		this.notes = notes;
		this.slot = slot;
		this.healthWorker = healthWorker;
		this.patient = patient;
	}




	//EQUALS AND HASHCODE
	@Override
	public int hashCode() {
		return getClass().hashCode();	
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment )) return false;
        return id != null && id.equals(((Appointment) o).getId());
    }
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", status=" + status + ", notes=" + notes + ", slot=" + slot
				+ ", healthWorker=" + healthWorker + ", patient=" + patient + "]";
	}
	//GETTERS AND SETTERS
	
	
	
	public Long getId() {
		return id;
	}
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public HealthWorker getHealthWorker() {
		return healthWorker;
	}

	public void setHealthWorker(HealthWorker healthWorker) {
		this.healthWorker = healthWorker;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
