package com;

public class Theaters {
	
	private String ID;
	private String name;
	private String city;
	private int numberOfScreen;
	private Address address;
	private int seats;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumberOfScreen() {
		return numberOfScreen;
	}
	public void setNumberOfScreen(int numberOfScreen) {
		this.numberOfScreen = numberOfScreen;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}	

}
