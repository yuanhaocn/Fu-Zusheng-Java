package com.syc.bmi.domain;

public class BMI {

	private String id;
	private String recordTime;
	private String height;
	private String weight;
	private String bmi;
	private String bmiSign;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getBmiSign() {
		return bmiSign;
	}

	public void setBmiSign(String bmiSign) {
		this.bmiSign = bmiSign;
	}

}
