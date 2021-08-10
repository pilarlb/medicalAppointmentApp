package es.medcen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="health_specialties")
public class HealthSpecialty implements Serializable {
	
	//ojo que he puesto int aqui en vez de long
		@Id
		private int id;
		
		@Column(nullable = false)
		private String specialty;

		
		public HealthSpecialty(int id, String specialty) {
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
