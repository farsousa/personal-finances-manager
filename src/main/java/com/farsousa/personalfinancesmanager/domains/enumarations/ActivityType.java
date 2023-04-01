package com.farsousa.personalfinancesmanager.domains.enumarations;

public enum ActivityType {
	
	Entrada(0),
	Saída(1);
	
	private int code;
	
	private ActivityType(int value) {
		this.code = value;
	}
	
	private int getCode() {
		return this.code;
	}
	
	public static ActivityType getActivityTypeByCode(int code) {
		for(ActivityType activityType: ActivityType.values()) {
			if(activityType.getCode() == code) {
				return activityType;
			}
		}
		return null;
	}

}
