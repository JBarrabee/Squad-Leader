package net.squadleader.people;

import java.io.Serializable;

public class Person implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int PERSON_ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String STREET_ADDRESS;
	private String CITY;
	private String STATE;
	private String LATITUDE;
	private String LONGITUDE;
	private String DOB;
	private String ACCESS_LEVEL;
	
	public Person(){}
	
	
	
	
	public int getPERSON_ID() {
		return PERSON_ID;
	}




	public void setPERSON_ID(int pERSON_ID) {
		PERSON_ID = pERSON_ID;
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




	public String getLATITUDE() {
		return LATITUDE;
	}




	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}




	public String getLONGITUDE() {
		return LONGITUDE;
	}




	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}




	public String getDOB() {
		return DOB;
	}




	public void setDOB(String dOB) {
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
		return "Person ID = " + PERSON_ID + ", First name = " + FIRST_NAME
				+ "Last name = " + LAST_NAME + ", Email = " + EMAIL + 
				"Access Level = " + ACCESS_LEVEL + "Street Address = " + STREET_ADDRESS + 
				"City = " + CITY + "State = " + STATE +  "Birthday = " + DOB ;
	}
	
	
}
