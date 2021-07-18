package es.medcen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="individuals")
public class Individual implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "id_card", unique = true)
	private String idCard;
	
	private String name;
	private String surname;
	
	@Column(name = "birth_date", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	private String address;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	private String email;
}
