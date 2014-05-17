package edu.uco.bdavis42.weightliftingtoolbox;


public class User {

	private static User user;
	
	int benchMax;
	int squatMax;
	int deadliftMax;
	int rowMax;
	int inclineMax;
	int week;

	public int getBenchMax() {
		return benchMax;
	}

	public void setBenchMax(int benchMax) {
		this.benchMax = benchMax;
	}

	public int getSquatMax() {
		return squatMax;
	}

	public void setSquatMax(int squatMax) {
		this.squatMax = squatMax;
	}

	public int getDeadliftMax() {
		return deadliftMax;
	}

	public void setDeadliftMax(int deadliftMax) {
		this.deadliftMax = deadliftMax;
	}

	public int getRowMax() {
		return rowMax;
	}

	public void setRowMax(int rowMax) {
		this.rowMax = rowMax;
	}

	public int getInclineMax() {
		return inclineMax;
	}

	public void setInclineMax(int inclineMax) {
		this.inclineMax = inclineMax;
	}

	public void increaseWeight() {
		benchMax = benchMax + 5;
		squatMax = squatMax + 5;
		deadliftMax = deadliftMax + 5;
		rowMax = rowMax + 5;
		inclineMax = inclineMax + 5;
		week++;

	}
	
	public void decreaseWeight(){
		
		if(week > 0){
		benchMax = benchMax - 5;
		squatMax = squatMax - 5;
		deadliftMax = deadliftMax - 5;
		rowMax = rowMax - 5;
		inclineMax = inclineMax - 5;
		week--;
		}
	}

	private User() {

		benchMax = 0;
		squatMax = 0;
		deadliftMax = 0;
		rowMax = 0;
		inclineMax = 0;
		week = 1;

	}

	public static User getInstance() {
		if (user == null) {
			user = new User();
		}
		return user;
	}


}
