
package nl.hva.sisspringboot.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "profile_type")
@Table(name = "user_profile")
public abstract class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "gender", columnDefinition = "char(1) default 'M'")
	private char gender;

	private String initials;

	private String firstName;

	private String lastName;

	private String insertion;

	private String phoneNumber;

	private Date dateOfBirth;

	private String placeOfBirth;

	private String training;

	private String nationality;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public UserProfile(char gender, String initials, String firstName, String lastName, String insertion, Date dateOfBirth, String placeOfBirth, String training, String nationality) {
		this.gender = gender;
		this.initials = initials;
		this.firstName = firstName;
		this.lastName = lastName;
		this.insertion = insertion;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.training = training;
		this.nationality = nationality;
	}

	public UserProfile(char gender, String initials, String firstName, String lastName, String insertion, String phoneNumber, Date dateOfBirth, String placeOfBirth, String training, String nationality, Address address) {
		this.gender = gender;
		this.initials = initials;
		this.firstName = firstName;
		this.lastName = lastName;
		this.insertion = insertion;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.training = training;
		this.nationality = nationality;
		this.address = address;
	}

	public UserProfile() {

	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInsertion() {
		return insertion;
	}

	public void setInsertion(String insertion) {
		this.insertion = insertion;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
