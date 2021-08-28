package es.medcen.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Individual{
	
	/**
	 * Clase padre para que hereden de ella atributos y metodos
	 */
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

	
	public Individual() {
		super();
	}

	public Individual(String idCard, String name, String surname, Date birthDate, String phoneNumber, String address,
			String postalCode, String email) {
		super();
		this.idCard = idCard;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
