package net.squadleader.people;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String STREET_ADDRESS;
	private String CITY;
	private String STATE;
	private Date DOB;
	private String ACCESS_LEVEL;
	
	public Person(){}

	
	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getFIRST_NAME() {
		return FIRST_NAME;
	}



	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}



	public String getLAST_NAME() {
		return LAST_NAME;
	}



	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}



	public String getEMAIL() {
		return EMAIL;
	}



	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}



	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}



	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;
	}



	public String getCITY() {
		return CITY;
	}



	public void setCITY(String cITY) {
		CITY = cITY;
	}



	public String getSTATE() {
		return STATE;
	}



	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}



	public Date getDOB() {
		return DOB;
	}



	public void setDOB(Date dOB) {
		DOB = dOB;
	}



	public String getACCESS_LEVEL() {
		return ACCESS_LEVEL;
	}



	public void setACCESS_LEVEL(String aCCESS_LEVEL) {
		ACCESS_LEVEL = aCCESS_LEVEL;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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
