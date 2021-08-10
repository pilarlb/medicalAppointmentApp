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
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Ojo he puesto strings, podrian ser int
	@Column(name = "appointment_time")
	private String appointmentTime;
	
	private boolean available;
	
	//lado de NO foreign key
	@OneToOne(mappedBy="slot")
	private Appointment appointment;
	
	//bidirectional horario
	@ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;
}
