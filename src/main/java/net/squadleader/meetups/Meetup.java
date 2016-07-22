package net.squadleader.meetups;

import net.squadleader.meetups.Meetup;
import java.io.Serializable;
import java.util.Date;

public class Meetup implements Serializable {

	private static final long serialVersionUID = 1L;

	private int MEETUP_ID;
	private String GROUP_URL;
	private String GROUP_NAME;
	private String EVENT_NAME;
	private String EVENT_DATE;
	private String EVENT_VENUE_NAME;
	private String EVENT_STREET;
	private String EVENT_CITY;
	private String EVENT_STATE;
	private String EVENT_ZIP;
	private String EVENT_LATITUDE;
	private String EVENT_LONGITUDE;
	private String EVENT_LINK;

	public Meetup() {
	}

	public int getMEETUP_ID() {
		return MEETUP_ID;
	}

	public void setMEETUP_ID(int mEETUP_ID) {
		MEETUP_ID = mEETUP_ID;
	}

	public String getGROUP_URL() {
		return GROUP_URL;
	}

	public void setGROUP_URL(String gROUP_URL) {
		GROUP_URL = gROUP_URL;
	}

	public String getGROUP_NAME() {
		return GROUP_NAME;
	}

	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}

	public String getEVENT_NAME() {
		return EVENT_NAME;
	}

	public void setEVENT_NAME(String eVENT_NAME) {
		EVENT_NAME = eVENT_NAME;
	}

	public String getEVENT_DATE() {
		return EVENT_DATE;
	}

	public void setEVENT_DATE(String eVENT_DATE) {
		EVENT_DATE = eVENT_DATE;
	}

	public String getEVENT_VENUE_NAME() {
		return EVENT_VENUE_NAME;
	}

	public void setEVENT_VENUE_NAME(String eVENT_VENUE_NAME) {
		EVENT_VENUE_NAME = eVENT_VENUE_NAME;
	}

	public String getEVENT_STREET() {
		return EVENT_STREET;
	}

	public void setEVENT_STREET(String eVENT_STREET) {
		EVENT_STREET = eVENT_STREET;
	}

	public String getEVENT_CITY() {
		return EVENT_CITY;
	}

	public void setEVENT_CITY(String eVENT_CITY) {
		EVENT_CITY = eVENT_CITY;
	}

	public String getEVENT_STATE() {
		return EVENT_STATE;
	}

	public void setEVENT_STATE(String eVENT_STATE) {
		EVENT_STATE = eVENT_STATE;
	}

	public String getEVENT_ZIP() {
		return EVENT_ZIP;
	}

	public void setEVENT_ZIP(String eVENT_ZIP) {
		EVENT_ZIP = eVENT_ZIP;
	}

	public String getEVENT_LATITUDE() {
		return EVENT_LATITUDE;
	}

	public void setEVENT_LATITUDE(String eVENT_LATITUDE) {
		EVENT_LATITUDE = eVENT_LATITUDE;
	}

	public String getEVENT_LONGITUDE() {
		return EVENT_LONGITUDE;
	}

	public void setEVENT_LONGITUDE(String eVENT_LONGITUDE) {
		EVENT_LONGITUDE = eVENT_LONGITUDE;
	}

	public String getEVENT_LINK() {
		return EVENT_LINK;
	}

	public void setEVENT_LINK(String eVENT_LINK) {
		EVENT_LINK = eVENT_LINK;
	}

	/*
	 * public static long getSerialversionuid() { return serialVersionUID; }
	 */

	@Override
	public int compareTo(eventArray comparestu) {
		int compareage = ((eventArray) comparestu).getEVENT_DATE();
		/* For Ascending order */
		return this.studentage - compareage;

		/* For Descending order do like this */
		// return compareage-this.studentage;
	}

	@Override
	public String toString() {
		return "Meetup ID = " + MEETUP_ID + ", Group URL = " + GROUP_URL + ", Event Name = " + EVENT_NAME
				+ ", Event Date = " + EVENT_DATE + ", Event Venue Name = " + EVENT_VENUE_NAME + ", Event Street = "
				+ EVENT_STREET + ", Event City = " + EVENT_CITY + ", Event State = " + EVENT_STATE + ", Event ZIP = "
				+ EVENT_ZIP + ", Event Latitude = " + EVENT_LATITUDE + ", Event Logitude" + EVENT_LONGITUDE;

	}

}
