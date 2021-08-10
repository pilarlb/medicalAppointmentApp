package es.medcen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="individuals")
public class Individual implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_card", unique = true, nullable = false)
	private String idCard;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	
	@Column(name = "birth_date", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	private String address;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	private String email;
	
	//side of no FK
	@OneToOne(mappedBy= "individual")
	private Patient patient;
	//side of no FK
	@OneToOne(mappedBy= "individual")
	private HealthWorker healthWorker;
}
