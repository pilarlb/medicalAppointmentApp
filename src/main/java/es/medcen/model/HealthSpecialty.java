package es.medcen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="health_specialties")
public class HealthSpecialty implements Serializable {
	
		@Id
		private Long id;
		
		@Column(nullable = false)
		private String specialty;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private HealthWorker healthworker;

		
		//CONSTRUCTOR
		public HealthSpecialty() {
			super();
		}
		
		public HealthSpecialty(Long id, String specialty, HealthWorker healthworker) {
			super();
			this.id = id;
			this.specialty = specialty;
			this.healthworker = healthworker;
		}
		//EQUALS AND HASHCODE
		@Override
		public int hashCode() {
			return getClass().hashCode();	
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof HealthSpecialty )) return false;
	        return id != null && id.equals(((HealthSpecialty) o).getId());
	    }
		//GETTERS AND SETTERS
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSpecialty() {
			return specialty;
		}

		

		public void setSpecialty(String specialty) {
			this.specialty = specialty;
		}

		public HealthWorker getHealthworker() {
			return healthworker;
		}

		public void setHealthworker(HealthWorker healthworker) {
			this.healthworker = healthworker;
		}
		
		
		
}
