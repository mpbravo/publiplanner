package com.jboss.publiplanner.domain;


public class Video {

	private Customer customer;
	
	private String name;
	
	private int duration;
	
	public Video(Customer customer, String name, int duration){
		this.customer = customer;
		this.name = name;
		this.duration = duration;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
