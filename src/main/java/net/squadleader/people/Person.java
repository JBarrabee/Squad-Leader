package net.squadleader.people;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Person implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	

	private int ID;

	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String STREET_ADDRESS;
	private String CITY;
	private String STATE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DOB;
	private String LATITUDE;
	private String LONGITUDE;

	

	private String ACCESS_LEVEL;
	
	public Person(){}

	public int getID() {
		return ID;

	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	
	public void setFIRST_NAME(String FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;

	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String LAST_NAME) {
		this.LAST_NAME = LAST_NAME;
	}
	
	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}
	
	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;

	}
	
	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;

	}
	
	public void setCITY(String CITY) {
		this.CITY = CITY;

	}
	
	public String getCITY() {
		return CITY;
	}
	
	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}
	
	public String getSTATE() {
		return STATE;
	}
	
	public void setLATITUDE(String LATITUDE) {
		this.LATITUDE = LATITUDE;
	}
	
	public String getLATITUDE() {
		return LATITUDE;
	}
	
	public void setLONGITUDE(String LONGITUDE) {
		this.LONGITUDE = LONGITUDE;
	}
	
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	
	public Date getDOB() {
		return DOB;
	}
	
	public void setACCESS_LEVEL(String ACCESS_LEVEL) {
		this.ACCESS_LEVEL = ACCESS_LEVEL;
	}
	
	public String getACCESS_LEVEL() {
		return ACCESS_LEVEL;
	}


	@Override
	public String toString() {
		return "ID = " + ID + ", First name = " + FIRST_NAME
				+ "Last name = " + LAST_NAME + ", Email = " + EMAIL + 
				"Access Level = " + ACCESS_LEVEL + "Street Address = " + STREET_ADDRESS + 
				"City = " + CITY + "State = " + STATE + 
				"Birthday = " + DOB;

	}
	
	
}
