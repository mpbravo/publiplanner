package com.jboss.publiplanner.domain;

import java.time.LocalDateTime;

public class Block {

	private Channel channel;
	
	private LocalDateTime startingTime;
	
	private int capacity;
	
	private int grps;
	
	public Block(Channel channel, LocalDateTime startingTime, int capacity, int grps){
		this.channel = channel;
		this.startingTime = startingTime;
		this.capacity = capacity;
		this.grps = grps;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public LocalDateTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(LocalDateTime startingTime) {
		this.startingTime = startingTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getGrps() {
		return grps;
	}

	public void setGrps(int grps) {
		this.grps = grps;
	}
	
	// ************************************************************************
    // Complex methods
    // ************************************************************************
	
	public boolean isPrimeTime(){
		return (startingTime != null) ? 
				((startingTime.getHour() >= 20) || (startingTime.getHour() == 0)) && ((startingTime.getMinute() >= 0) && (startingTime.getMinute() <= 30)) : false;
	}
	
	public boolean isInPeriod(LocalDateTime start, LocalDateTime end){
		return (startingTime != null) ? 
				(startingTime.isAfter(start) && startingTime.isBefore(end)) : false;
	}
	
	public boolean isSameDay(LocalDateTime day){
		return (startingTime != null) ? startingTime.getDayOfYear() == day.getDayOfYear() : false;
	}
}
