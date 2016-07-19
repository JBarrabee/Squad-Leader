package net.squadleader.people;

import java.io.Serializable;

public class Person implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int PERSON_ID;
	private String firstName;
	private String lastName;
	private String email;
	private String accessLevel;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String birthday;
	
	public Person(){}
	
	
	public int getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(int personID) {
		this.PERSON_ID = personID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	@Override
	public String toString() {
		return "Person ID = " + PERSON_ID + ", First name = " + firstName
				+ "Last name = " + lastName + ", Email = " + email + 
				"Access Level = " + accessLevel + "Street Address = " + streetAddress + 
				"City = " + city + "State = " + state + "Zip Code = " + zipCode + 
				"Birthday = " + birthday;
	}
	
	
}
