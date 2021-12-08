package es.medcen.app.model;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="schedules")
public class Schedule implements Serializable{
	
	
	private static final long serialVersionUID = -5606623658012630380L;
	
	/**
	 * Horario por dia del doctor
	 * -ID
	 * -FECHA/DATE
	 * -IS_WORKING_DAY
	 * -ID_DOCTOR
	 * -LISTA_SLOTS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Calendar date;
	
	@Column(name="formatted_date")
	private String formattedDate;
	
	@Column(name = "is_working_day")
	private boolean isWorkingDay;
	
	//bidirectional varios horarios a un doctor
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    private HealthWorker healthWorker;
	
	/*
	 * oneToMany bidireccional: metodos a implementar
	 * - En el padre (one) addComment y removeComment
	 * - en el hijo (many) equals y hashCode
	 */
	//bidireccional REVISAR orphanRemoval
	@JsonIgnore
	@OneToMany(mappedBy="schedule",cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="slots")
	private List<Slot> slots= new ArrayList<>();

	
	//CONSTRUCTOR
	public Schedule() {
		super();
	}
	
	
	public Schedule(Calendar date, boolean isWorkingDay, HealthWorker healthWorker, List<Slot> slots) {
		super();
		this.date = date;
		this.isWorkingDay = isWorkingDay;
		this.healthWorker = healthWorker;
		this.slots = slots;
	}
	
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", isWorkingDay=" + isWorkingDay + ", healthWorker="
				+ healthWorker + ", slots=" + slots + "]";
	}

	
	/*
	 * METHODS FOR ADDING AND REMOVING SLOTS
	 */

	

	public void addSlot(Slot slot){
		slots.add(slot);
		slot.setSchedule(this);
	
	}
	public void removeSlot(Slot slot){
		slots.remove(slot);
		slot.setSchedule(null);
	
	}
	
	
	
	//EQUALS AND HASHCODE
	@Override
	public int hashCode() {
		return getClass().hashCode();	
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule )) return false;
        return id != null && id.equals(((Schedule) o).getId());
    }


	//GETTERS AND SETTERS
	
	public String getFormattedDate() {
		return formattedDate;
	}


	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	public Calendar getDate() {
		return date;
	}



	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isWorkingDay() {
		return isWorkingDay;
	}

	public void setWorkingDay(boolean isWorkingDay) {
		this.isWorkingDay = isWorkingDay;
	}

	public HealthWorker getHealthWorker() {
		return healthWorker;
	}

	public void setHealthWorker(HealthWorker healthWorker) {
		this.healthWorker = healthWorker;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
}
