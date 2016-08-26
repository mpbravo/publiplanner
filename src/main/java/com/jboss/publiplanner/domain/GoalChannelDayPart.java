package com.jboss.publiplanner.domain;

public class GoalChannelDayPart {
	
	private Customer customer;
	
	private Channel channel;
	
	private int grpPrimeTime;
	
	private int grpDayTime;
	
	public GoalChannelDayPart(Customer customer, Channel channel, int grpPrimeTime, int grpDayTime){
		this.customer = customer;
		this.channel = channel;
		this.grpDayTime = grpDayTime;
		this.grpPrimeTime = grpPrimeTime;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public int getGrpPrimeTime() {
		return grpPrimeTime;
	}

	public void setGrpPrimeTime(int grpPrimeTime) {
		this.grpPrimeTime = grpPrimeTime;
	}

	public int getGrpDayTime() {
		return grpDayTime;
	}

	public void setGrpDayTime(int grpDayTime) {
		this.grpDayTime = grpDayTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
