package com.jboss.publiplanner.domain;

import java.time.LocalDateTime;

public class GoalPeriodTime {
	
	private Customer customer;
	
	private LocalDateTime start;
	
	private LocalDateTime end;
	
	private int duration;
	
	private int grpGoal;
	
	public GoalPeriodTime(Customer customer, LocalDateTime start, LocalDateTime end, int duration, int grpGoal){
		this.customer = customer;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.grpGoal = grpGoal;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getGrpGoal() {
		return grpGoal;
	}

	public void setGrpGoal(int grpGoal) {
		this.grpGoal = grpGoal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
