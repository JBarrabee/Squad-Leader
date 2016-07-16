package com.squadLeader.enums;

public enum States {
	ALABAMA, ALASKA, ARIZONA, ARKANSAS, CALIFORINA, COLORADO, CONNECTICUT, DELAWARE, FLORIDA, GEORGIA, HAWAII, IDAHO, ILLINOIS, INDIANA, IOWA, KANSAS, KENTUCKY, LOUISIANA, MAINE, MARYLAND, MASSACHUSETTS, MICHIGAN, MINNESOTA, MISSISSIPPI, MISSOURI, MONTANA, NEBRASKA, NEVADA, NEW_HAMPSHIRE, NEW_JERSEY, NEW_MEXICO, NORTH_CAROLINA, NORTH_DAKOTA, OHIO, OKLAHOMA, OREGON, PENNSYLVANIA, RHODE_ISLAND, SOUTH_CAROLINA, SOUTH_DAKOTA, TENNESSEE, TEXAS, UTAH, VERMONT, VIRGINIA, WASHINGTON, WEST_VIRGINIA, WISCONSIN, WYOMING;

	private String fullState;

	private void StateConstantsEnum(String s) {
		fullState = s;
	}

	public String getStates() {
		return fullState;
	}

}
