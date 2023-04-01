package com.farsousa.personalfinancesmanager.domains.enumarations;

public enum ActivityStatus {
	
	Pendente(0),
	Efetuado(1);
	
	private int code;
	
	private ActivityStatus(int code) {
		this.code = code;
	}
	
	private int getCode() {
		return this.code;
	}

	public static ActivityStatus getByCode(int code) {
		for(ActivityStatus activityStatus : ActivityStatus.values()) {
			if(activityStatus.getCode() == code) {
				return activityStatus;
			}
		}
		return null;
	}

}
