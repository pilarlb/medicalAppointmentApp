package es.medcen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="health_specialties")
public class HealthSpecialties implements Serializable {
	
	
	@Id
	private int id;
	
	@Column(nullable = false)
	private String specialty;

	public HealthSpecialties(int id, String specialty) {
		super();
		this.id = id;
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	
}
