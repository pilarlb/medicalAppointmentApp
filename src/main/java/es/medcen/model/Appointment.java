package es.medcen.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	//Relacion uno a uno: una cita, un slot
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "slot")
	private Slot slot;
	
	//bidirectional 
	@ManyToOne(fetch = FetchType.LAZY)
    private HealthWorker healthWorker;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

}
