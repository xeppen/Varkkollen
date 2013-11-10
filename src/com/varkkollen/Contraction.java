package com.varkkollen;

import java.lang.reflect.Array;

public class Contraction {
	Integer startTime = 0;
	Integer stopTime = 0;
	Integer duration_min = 0;
	Integer duration_sec = 0;
	Integer intencity = 0;
	String note = "";
	
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getStopTime() {
		return stopTime;
	}
	public void setStopTime(Integer stopTime) {
		this.stopTime = stopTime;
	}
	public Integer getDurationMin() {
		return duration_min;
	}
	public void setDurationMin(Integer duration) {
		this.duration_min = duration;
	}
	public Integer getDurationSec() {
		return duration_sec;
	}
	public void setDurationSec(Integer duration) {
		this.duration_sec = duration;
	}
	public Integer getIntencity() {
		return intencity;
	}
	public void setIntencity(Integer intencity) {
		this.intencity = intencity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
