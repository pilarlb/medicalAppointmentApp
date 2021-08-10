package es.medcen.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="schedules")
public class Schedule implements Serializable{
	/**
	 * Horario por dia del doctor
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Calendar date;
	
	@Column(name = "is_working_day")
	private boolean isWorkingDay;
	
	//bidirectional varios horarios a un doctor
	@ManyToOne(fetch = FetchType.LAZY)
    private HealthWorker healthWorker;
	
	//bidireccional REVISAR orphanRemoval
	@OneToMany(mappedBy="schedule",cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="slots")
	private List<Slot> slots;
	
	
}
